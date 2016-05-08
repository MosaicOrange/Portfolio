class Sample
{
    string _sampleName;
    string _containerName;
    double _sampleNumber;
    bool _sampleBoolean;

    public Sample(string SampleName, string ContainerName, double SampleNumber, int SampleBoolean)
    {
        this._sampleName = SampleName;
        this._containerName = ContainerName;
        this._sampleNumber = SampleNumber;
        this._sampleBoolean = (SampleBoolean == 1) ? true : false;
    }

    public string getSmpName()
    {
        return this._sampleName;
    }

    public string getContName()
    {
        return this._containerName;
    }

    public double getSmpNo()
    {
        return this._sampleNumber;
    }

    public bool getSampBool()
    {
        return this._sampleBoolean;
    }
}