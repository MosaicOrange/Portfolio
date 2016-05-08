using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;
using System.Xml.Linq;

class Functions
{
    static List<Sample> collOfSmp = new List<Sample>();
    static List<Container> collOfCont = new List<Container>();
    static Package packageFile;
    static string passingInput = "";
    static string dirPath = @"../../";

    internal static double Conversion(string SmpNoUnit, string SmpNo)
    {
        double incUnits = Double.Parse(SmpNo, System.Globalization.NumberStyles.Float);
        double valueInUnits = 0;
        if (SmpNoUnit.Equals("MilliUnits"))
        {
            valueInUnits = incUnits * 0.001;
        }
        else if (SmpNoUnit.Equals("DifferentUnits"))
        {
            valueInUnits = incUnits * 18.19726;
        }
        else if (SmpNoUnit.Equals("Units"))
        {
            valueInUnits = incUnits;
        }
        return valueInUnits;
    }

    internal static double TotalBoolValue(List<Sample> SmpBoolLst, bool SmpBool)
    {
        double trueTotal = 0;
        double falseTotal = 0;
        foreach (Sample value in SmpBoolLst)
        {
            if (value.getSampBool())
            {
                trueTotal = trueTotal + value.getSmpNo();
            }
            else if (!value.getSampBool())
            {
                falseTotal = falseTotal + value.getSmpNo();
            }
        }
        if (SmpBool)
        {
            return trueTotal;
        }
        else if (!SmpBool)
        {
            return falseTotal;
        }
        else
        {
            return 0;
        }
    }

    internal static bool ValidateInput(string ToBeChecked)
    {
        Regex checkInput = new Regex("^[a-zA-Z0-9]*$");
        bool validation;
        if (checkInput.IsMatch(ToBeChecked))
        {
            validation = true;
        }
        else
        {
            Console.WriteLine("Only input with alphanumeric characters is accepted. Please try again.");
            validation = false;
        }
        return validation;
    }

    internal static void AcceptInput()
    {
        while (!File.Exists(dirPath + passingInput + ".xml"))
        {
            Console.WriteLine("Using only alphanumeric characters, please enter the name of the XML file. \nNo extension required.");
            do
            {
                passingInput = Console.ReadLine();
            } while (!ValidateInput(passingInput));
            if (!File.Exists(dirPath + passingInput + ".xml"))
            {
                Console.WriteLine("File does not exist, would you like to try again? \n(Y)es or (N)o");
                string userResponse = Console.ReadLine().ToLower();
                if (userResponse.Equals("n") || userResponse.Equals("no"))
                {
                    Environment.Exit(0);
                }
                else if (!(userResponse.Equals("y") || userResponse.Equals("yes")))
                {
                    Console.WriteLine("Invalid reponse, please try again");
                }
            }
        }
    }

    internal static void Populate()
    {
        Sample smp;
        Container cont;
        foreach (XElement containerElement in XElement.Load(dirPath + passingInput + ".xml").Elements("container"))
        {
            string smpNoUnit = containerElement.Attribute("samplenumberunit").Value;
            foreach (XElement samplesElement in containerElement.Elements("samples"))
            {
                foreach (XElement sampleElement in samplesElement.Elements("sample"))
                {
                    smp = new Sample(sampleElement.Attribute("samplename").Value,
                        containerElement.Attribute("containername").Value,
                        Conversion(smpNoUnit, sampleElement.Attribute("samplenumber").Value),
                        int.Parse(sampleElement.Attribute("sampleboolean").Value));
                    collOfSmp.Add(smp);
                }
            }
            cont = new Container(containerElement.Attribute("containername").Value, containerElement.Attribute("samplenumberunit").Value, collOfSmp);
            collOfCont.Add(cont);
        }
        packageFile = new Package(collOfCont);
    }

    internal static void CreateHTML(Package Package)
    {
        double totTrueNo = TotalBoolValue(collOfSmp, true);
        double totFalseNo = TotalBoolValue(collOfSmp, false);
        double theRatioNo = totFalseNo/totTrueNo;

        string htmlDocument = @"<html><head><title>" + passingInput.ToUpper() + "</title></head><style>table, th, td {border:2px solid black;} th, td" +
            "{width:250;text-align:center;padding:10px;border: 2px solid black;}</style><body><table><tr><th>False Numbers</th><th>True Numbers</th>" +
            "<th>False/True Ratio</th></tr><tr><td>" + string.Format("{0:#.##E+00}", totFalseNo) + "</td><td>" + string.Format("{0:#.##E+00}", totTrueNo) +
            "</td><td>" + string.Format("{0:#.##E+00}", theRatioNo) + "</td></tr></table>";
        
        string dataOutput = "<br><table><tr><th colspan=2>Package</th><th colspan=2>Number of Containers: " + Package.getNoOfCont() + "</th></tr>";
        foreach (Container contValue in Package.getListOfCont())
        {
            dataOutput = dataOutput + "<tr><td colspan=2>" + contValue.getContName() + "</td><td colspan=2>Original Sample Unit Type: " + contValue.getSmpNoUnit()
                + "</td></tr><tr><th>Sample Name</th><th>Sample Material</th><th>Sample Number Amount (Units)</th><th>Boolean</th></tr>";
            int x = 1;
            foreach (Sample smpValue in contValue.getListOfSmp())
            {
                if (contValue.getContName() == smpValue.getContName())
                {
                    dataOutput = dataOutput + "<tr><td>Sample " + x + "</td><td>" + smpValue.getSmpName() + "</td><td>" +
                        string.Format("{0:#.##E+00}", smpValue.getSmpNo()) + "</td><td>" + smpValue.getSampBool() + "</td></tr>";
                    x++;
                }
            }
        }
        dataOutput = dataOutput + "</table>";

        using (FileStream fileStreamHTML = new FileStream(dirPath + passingInput + ".html", FileMode.Create))
        {
            using (StreamWriter creatingHTML = new StreamWriter(fileStreamHTML, Encoding.UTF8))
            {
                creatingHTML.WriteLine(htmlDocument + dataOutput + @"</body></html>");
            }
        }
        Console.WriteLine("Complete! Press any key to exit.");
        Console.ReadLine();
        Environment.Exit(0);
    }

    internal static void HTMLDoc()
    {
        while (File.Exists(dirPath + passingInput + ".html"))
        {
            Console.WriteLine("Caution: File Already Exists! Overwrite? \n(Y)es, (N)o or (R)ename?");
            string userResponse = Console.ReadLine().ToLower();

            if (userResponse.Equals("r") || userResponse.Equals("rename"))
            {
                string newFileName;
                Console.WriteLine("Chose a new file name, using only number and letters.");
                do
                {
                    newFileName = Console.ReadLine();
                } while (!ValidateInput(passingInput) && !newFileName.Equals(null));
                passingInput = newFileName;
            }
            else if (userResponse.Equals("n") || userResponse.Equals("no"))
            {
                Environment.Exit(0);
            }
            else if (!(userResponse.Equals("y") || userResponse.Equals("yes")))
            {
                Console.WriteLine("Invalid reponse, please try again");
            }
            else
            {
                break;
            }
        }
        CreateHTML(packageFile);
    }
}