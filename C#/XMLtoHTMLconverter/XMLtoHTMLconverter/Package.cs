using System.Collections.Generic;

class Package
{
    List<Container> _listOfContainers;

    public Package(List<Container> ListOfContainers)
    {
        this._listOfContainers = ListOfContainers;
    }

    public List<Container> getListOfCont()
    {
        return this._listOfContainers;
    }

    public int getNoOfCont()
    {
        return this._listOfContainers.Count;
    }
}