package prj5;

import java.util.Arrays;
import student.TestCase;

/**
 * Tests the methods of SinglyLinkedList
 * 
 * @author Team 155
 * @version 11/16/2023
 */
public class SinglyLinkedListTest
    extends TestCase
{

    private SinglyLinkedList<String> emptyListA;
    private SinglyLinkedList<String> emptyListB;
    private SinglyLinkedList<String> smallListA;
    private SinglyLinkedList<String> smallListB;
    private SinglyLinkedList<String> bigListA;
    private SinglyLinkedList<String> bigListB;
    private String nullObject;
    private SinglyLinkedList<String> ascendingOrderList;
    private SinglyLinkedList<String> descendingOrderList;

    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp()
    {
        emptyListA = new SinglyLinkedList<String>();
        emptyListB = new SinglyLinkedList<String>();

        smallListA = new SinglyLinkedList<String>();
        smallListB = new SinglyLinkedList<String>();

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");

        bigListA = new SinglyLinkedList<String>();

        for (int i = 0; i < 100; i++)
        {
            bigListA.add("sport" + i);
        }

        bigListB = new SinglyLinkedList<String>();
        for (int i = 0; i < 100; i++)
        {
            bigListB.add("sport" + i);
        }

        // to be explicit
        nullObject = null;

        ascendingOrderList = new SinglyLinkedList<>();
        for (int i = 1; i <= 5; i++)
        {
            ascendingOrderList.add(String.valueOf(i));
        }

        descendingOrderList = new SinglyLinkedList<>();
        for (int i = 5; i >= 1; i--)
        {
            descendingOrderList.add(String.valueOf(i));
        }
    }


    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList()
    {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList()
    {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        // Make smallListA and smallListB differ in
        // content, but have the same size
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        // Replace the last element in smallListA
        // to make smallListA and smallListB equal again
        smallListA.remove("rope jumping");
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList()
    {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        // Same content, same size, but reversed
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--)
        {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // one a subset of the other but with dups
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++)
        {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++)
        {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // make them equal again
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++)
        {
            bigListB.add("sport" + i);
        }
        assertEquals(bigListA, bigListB);

    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty()
    {

        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));

    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents()
    {

        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));

    }


    /**
     * Tests the size method
     */
    public void testSize()
    {

        assertEquals(smallListB.size(), 3);
        smallListB.add("tennis");
        assertEquals(smallListB.size(), 4);
        smallListB.remove("tennis");
        assertEquals(smallListB.size(), 3);
    }


    /**
     * Tests the add(int index, E obj) method
     */
    public void testAddDoubleArg()
    {
        boolean nosuchelem = false;
        try
        {
            smallListB.add(1, null);
        }
        catch (IllegalArgumentException e)
        {
            nosuchelem = true;
        }
        assertTrue(nosuchelem);

        boolean nosuchelem2 = false;
        try
        {
            smallListB.add(-1, "tennis");
        }
        catch (IndexOutOfBoundsException e)
        {
            nosuchelem2 = true;
        }
        assertTrue(nosuchelem2);

        boolean nosuchelem3 = false;
        try
        {
            smallListB.add(5, "tennis");
        }
        catch (IndexOutOfBoundsException e)
        {
            nosuchelem3 = true;
        }
        assertTrue(nosuchelem3);
        assertEquals(0, emptyListA.size());
        emptyListA.add(0, "swimming");
        assertEquals(1, emptyListA.size());
        assertTrue(emptyListA.contains("swimming"));
        emptyListA.add(0, "tennis");
        assertEquals(2, emptyListA.size());
        assertTrue(emptyListA.contains("tennis"));
        assertEquals("tennis", emptyListA.get(0));
        emptyListA.add(1, "football");
        assertEquals(3, emptyListA.size());
        assertTrue(emptyListA.contains("football"));
        assertEquals("football", emptyListA.get(1));
        assertEquals("swimming", emptyListA.get(2));
        emptyListA.add(3, "basketball");
        assertEquals(4, emptyListA.size());
        assertEquals("basketball", emptyListA.get(3));
        assertTrue(emptyListA.contains("basketball"));
    }


    /**
     * Tests the add(E obj) method
     */
    public void testAddSingleArg()
    {
        boolean nosuchelem = false;
        try
        {
            smallListB.add(null);
        }
        catch (IllegalArgumentException e)
        {
            nosuchelem = true;
        }
        assertTrue(nosuchelem);
        assertEquals(0, emptyListA.size());
        emptyListA.add("swimming");
        assertEquals(1, emptyListA.size());
        assertTrue(emptyListA.contains("swimming"));
        emptyListA.add("tennis");
        assertEquals(2, emptyListA.size());
        assertTrue(emptyListA.contains("tennis"));
        assertEquals("tennis", emptyListA.get(1));
        emptyListA.add("football");
        assertEquals(3, emptyListA.size());
        assertTrue(emptyListA.contains("football"));
        assertEquals("football", emptyListA.get(2));
        assertEquals("tennis", emptyListA.get(1));
        assertEquals("swimming", emptyListA.get(0));
    }


    /**
     * Tests the isEmpty method
     */
    public void testIsEmpty()
    {
        assertTrue(emptyListA.isEmpty());
        emptyListA.add("tennis");
        assertFalse(emptyListA.isEmpty());
        emptyListA.remove("tennis");
        assertTrue(emptyListA.isEmpty());
    }


    /**
     * Tests the remove(E obj) method
     */
    public void testRemoveObj()
    {
        emptyListA.add("swimming");
        assertEquals(1, emptyListA.size());
        assertTrue(emptyListA.remove("swimming"));
        assertEquals(0, emptyListA.size());
        assertFalse(emptyListA.remove("swimming"));
        emptyListA.add("swimming");
        emptyListA.add("tennis");
        emptyListA.add("football");
        assertEquals(3, emptyListA.size());
        assertTrue(emptyListA.remove("football"));
        assertEquals(2, emptyListA.size());
        assertFalse(emptyListA.remove("football"));
        emptyListA.add("football");
        assertEquals(3, emptyListA.size());
        assertTrue(emptyListA.remove("tennis"));
        assertEquals(2, emptyListA.size());
        assertEquals("football", emptyListA.get(1));
        assertFalse(emptyListA.remove("tennis"));
    }


    /**
     * Tests the remove(int index) method
     */
    public void testRemoveInd()
    {
        boolean nosuchelem = false;
        try
        {
            smallListB.remove(-1);
        }
        catch (IndexOutOfBoundsException e)
        {
            nosuchelem = true;
        }
        assertTrue(nosuchelem);
        boolean nosuchelem2 = false;
        try
        {
            emptyListA.remove(0);
        }
        catch (IndexOutOfBoundsException e)
        {
            nosuchelem2 = true;
        }
        assertTrue(nosuchelem2);
        emptyListA.add("swimming");
        boolean nosuchelem5 = false;
        try
        {
            emptyListA.remove(1);
        }
        catch (IndexOutOfBoundsException e)
        {
            nosuchelem5 = true;
        }
        assertTrue(nosuchelem5);
        assertEquals(1, emptyListA.size());
        assertTrue(emptyListA.remove(0));
        assertEquals(0, emptyListA.size());
        emptyListA.add("swimming");
        emptyListA.add("tennis");
        emptyListA.add("football");
        assertEquals(3, emptyListA.size());
        assertTrue(emptyListA.remove(2));
        assertEquals(2, emptyListA.size());
        boolean nosuchelem3 = false;
        try
        {
            emptyListA.remove(2);
        }
        catch (IndexOutOfBoundsException e)
        {
            nosuchelem3 = true;
        }
        assertTrue(nosuchelem3);
        assertFalse(emptyListA.contains("football"));
        emptyListA.add("football");
        assertEquals(3, emptyListA.size());
        assertTrue(emptyListA.remove(1));
        assertEquals(2, emptyListA.size());
        assertEquals("football", emptyListA.get(1));
        boolean nosuchelem4 = false;
        try
        {
            emptyListA.remove(2);
        }
        catch (IndexOutOfBoundsException e)
        {
            nosuchelem4 = true;
        }
        assertTrue(nosuchelem4);
        assertFalse(emptyListA.contains("tennis"));
    }


    /**
     * Tests the get method
     */
    public void testGet()
    {
        emptyListA.add("swimming");
        emptyListA.add("tennis");
        emptyListA.add("football");
        assertEquals("swimming", emptyListA.get(0));
        assertEquals("tennis", emptyListA.get(1));
        assertEquals("football", emptyListA.get(2));
        boolean nosuchelem3 = false;
        try
        {
            emptyListA.get(3);
        }
        catch (IndexOutOfBoundsException e)
        {
            nosuchelem3 = true;
        }
        assertTrue(nosuchelem3);
    }


    /**
     * Tests the contains method
     */
    public void testContains()
    {
        emptyListA.add("swimming");
        emptyListA.add("tennis");
        emptyListA.add("football");
        assertTrue(emptyListA.contains("swimming"));
        assertTrue(emptyListA.contains("tennis"));
        assertTrue(emptyListA.contains("football"));
        assertFalse(emptyListA.contains("soccer"));
    }


    /**
     * Tests the clear method
     */
    public void testClear()
    {
        assertEquals(0, emptyListA.size());
        emptyListA.clear();
        assertEquals(0, emptyListA.size());
        emptyListA.add("swimming");
        emptyListA.add("tennis");
        emptyListA.add("football");
        assertEquals(3, emptyListA.size());
        emptyListA.clear();
        assertEquals(0, emptyListA.size());
    }


    /**
     * Tests the lastIndexOf method
     */
    public void testLastIndexOf()
    {
        emptyListA.add("swimming");
        emptyListA.add("tennis");
        emptyListA.add("football");
        assertEquals(0, emptyListA.lastIndexOf("swimming"));
        emptyListA.add("swimming");
        assertEquals(3, emptyListA.lastIndexOf("swimming"));
        assertEquals(1, emptyListA.lastIndexOf("tennis"));
        assertEquals(2, emptyListA.lastIndexOf("football"));
        assertEquals(-1, emptyListA.lastIndexOf("soccer"));
    }


    /**
     * Tests the toString method
     */
    public void testToString()
    {
        assertEquals("{}", emptyListA.toString());
        emptyListA.add("swimming");
        emptyListA.add("tennis");
        emptyListA.add("football");
        assertEquals("{swimming, tennis, football}", emptyListA.toString());
    }


    /**
     * Tests the sort method
     */
    public void testSort()
    {
//        emptyListA.sort();
//        assertEquals("{}", emptyListA.toString());
//        emptyListA.add("swimming");
//        emptyListA.sort();
//        assertEquals("{swimming}", emptyListA.toString());
//        ascendingOrderList.sort();
//        assertEquals("{1, 2, 3, 4, 5}", ascendingOrderList.toString());
//        descendingOrderList.sort();
//        assertEquals("{1, 2, 3, 4, 5}", descendingOrderList.toString());
//        smallListA.sort();
//        assertEquals("{gymnastics, soccer, swimming}", smallListA.toString());
    }
}
