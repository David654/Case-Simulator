package cases;

import java.util.HashMap;

public class Case
{
    protected HashMap<String, String> c;

    public Case()
    {
        c = new HashMap<>();
    }

    public HashMap<String, String> getCase()
    {
        return c;
    }
}