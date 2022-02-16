package generator;

import cases.Case;

import java.util.*;

public class Generator
{
    private final HashMap<String, String> items;
    private final String[] rarities = new String[] {"Blue", "Purple", "Pink", "Red", "Gold"};
    private final float[] probabilities = new float[] {0.79f, 0.15f, 0.05f, 0.007f, 0.003f};
    private final String[] drop = new String[1000];
    private final String[] wear = new String[] {"Factory New", "Minimal Wear", "Field-Tested", "Well-Worn", "Battle-Scarred"};
    private final float[][] wearValues = new float[][] {
            new float[] {0.00f, 0.07f},
            new float[] {0.07f, 0.15f},
            new float[] {0.15f, 0.37f},
            new float[] {0.37f, 0.44f},
            new float[] {0.44f, 1.00f}
    };

    public Generator(Case c)
    {
        this.items = c.getCase();

        generate();
    }

    private void generate()
    {
        int n = 0;
        int counter = 0;
        for(int i = 0; i < drop.length; i++)
        {
            float p = probabilities[n];
            drop[i] = rarities[n];

            if(counter == drop.length * p)
            {
                counter = 0;
                n++;
            }
            counter++;
        }
    }

    public void drop()
    {
        List<String> list = Arrays.asList(drop);
        Collections.shuffle(list);
        print(dropItem(list));
    }

    private String[] dropItem(List<String> list)
    {
        Random r = new Random();
        String rarity = list.get(r.nextInt(list.size()));
        String item = getItemWithRarity(rarity);
        int index = r.nextInt(wearValues.length);
        float[] curr_wear = wearValues[index];
        float w = r.nextFloat(curr_wear[1] - curr_wear[0]) + curr_wear[0];
        return new String[] {item, rarity, wear[index], String.valueOf(w)};
    }

    private String getItemWithRarity(String rarity)
    {
        ArrayList<String> itemsWithRarity = new ArrayList<>();

        for(String item : items.keySet())
        {
            String currRarity = items.get(item);
            if(currRarity.equals(rarity))
            {
                itemsWithRarity.add(item);
            }
        }

        Random r = new Random();
        return itemsWithRarity.get(r.nextInt(itemsWithRarity.size()));
    }

    private void print(String[] s)
    {
        System.out.println("Item: " + s[0]);
        System.out.println("Rarity: " + s[1]);
        System.out.println("Wear: " + s[2]);
        System.out.println("Wear value: " + s[3]);
    }
}