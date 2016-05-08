using System.Collections.Generic;

class Container
{
    string _containerName;
    string _sampleNumberUnit;
    List<Sample> _listOfSamples;

    public Container(string ContainerName, string SampleNumberUnit, List<Sample> ListOfSamples)
    {
        this._containerName = ContainerName;
        this._sampleNumberUnit = SampleNumberUnit;
        this._listOfSamples = ListOfSamples;
    }

    public string getContName()
    {
        return this._containerName;
    }

    public string getSmpNoUnit()
    {
        return this._sampleNumberUnit;
    }

    public List<Sample> getListOfSmp()
    {
        return this._listOfSamples;
    }

    public int getNoOfSmp()
    {
        return this._listOfSamples.Count;
    }
}