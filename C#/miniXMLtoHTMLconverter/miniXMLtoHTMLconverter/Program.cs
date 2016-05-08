using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;
using System.Xml.Linq;

class Program
{
    static void Main()
    {
        string dirPath = @"../../";
        string passingInput = null;
        double trueTotal = 0;
        double falseTotal = 0;

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

        foreach (XElement containerElement in XElement.Load(dirPath + passingInput + ".xml").Elements("container"))
        {
            string smpNoUnit = containerElement.Attribute("samplenumberunit").Value;
            foreach (XElement samplesElement in containerElement.Elements("samples"))
            {
                foreach (XElement sampleElement in samplesElement.Elements("sample"))
                {

                    if (int.Parse(sampleElement.Attribute("sampleboolean").Value) == 1)
                    {
                        trueTotal = trueTotal + Conversion(smpNoUnit, sampleElement.Attribute("samplenumber").Value);
                    }
                    else if (int.Parse(sampleElement.Attribute("sampleboolean").Value) == 0)
                    {
                        falseTotal = falseTotal + Conversion(smpNoUnit, sampleElement.Attribute("samplenumber").Value);
                    } 
                }
            }
        }

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

        string totTrue = string.Format("{0:#.##E+00}", trueTotal);
        string totFalse = string.Format("{0:#.##E+00}", falseTotal);
        string theRatio = string.Format("{0:#.##E+00}", falseTotal / trueTotal);

        string htmlDocument = @"<html><head><title>" + passingInput.ToUpper() + "</title></head><style>table, th, td {border:2px solid black;} th, td" +
            "{width:250;text-align:center;padding:10px;border: 2px solid black;}</style><body><table><tr><th>False Numbers</th><th>True Numbers" +
            "</th><th>False/True Ratio</th></tr><tr><td>" + totFalse + "</td><td>" + totTrue + "</td><td>" + theRatio + "</td></tr></table></body></html>";

        using (FileStream fileStreamHTML = new FileStream(dirPath + passingInput + ".html", FileMode.Create))
        {
            using (StreamWriter creatingHTML = new StreamWriter(fileStreamHTML, Encoding.UTF8))
            {
                creatingHTML.WriteLine(htmlDocument);
            }
        }
        Console.WriteLine("Complete! Press any key to exit.");
        Console.ReadLine();
        Environment.Exit(0);
    }

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
}