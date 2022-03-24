using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace ITDEV154
{
    class Program
    {
        static void Main(string[] args)
        {
            int choice, data, k, x;

            SingleLinkedList list = new SingleLinkedList();

            list.CreateList();

            while (true)
            {
                choice = GetMenuChoice();

                if (choice == 18)
                    break;
                switch (choice)
                {
                    case 1: //display list
                        list.DisplayList();
                        break;
                    case 2: //count nodes
                        list.CountNodes();
                        break;
                    case 3: //search for node with specific value
                        WriteLine("Enter an integer value to search for: ");
                        data = Convert.ToInt32(ReadLine());
                        list.Search(data);
                        break;
                    case 4: //insert into an empty list
                        WriteLine("Enter an integer value to be inserted: ");
                        data = Convert.ToInt32(ReadLine());
                        list.InsertAtBeginning(data);
                        list.DisplayList();
                        break;
                    case 5: //insert at the end of the list
                        WriteLine("Enter an integer value to be inserted: ");
                        data = Convert.ToInt32(ReadLine());
                        list.InsertAtEnd(data);
                        list.DisplayList();
                        break;
                    case 6: //insert after a specified node
                        WriteLine("Enter an integer value to be inserted: ");
                        data = Convert.ToInt32(ReadLine());
                        WriteLine("Enter the value of the Node to be inserted after: ");
                        k = Convert.ToInt32(ReadLine());
                        list.InsertAfter(data, k);
                        list.DisplayList();
                        break;
                    case 7: //insert before a specified node
                        WriteLine("Enter an integer value to be inserted: ");
                        data = Convert.ToInt32(ReadLine());
                        WriteLine("Enter the value of the Node to be inserted before: ");
                        k = Convert.ToInt32(ReadLine());
                        list.InsertBefore(data, k);
                        list.DisplayList();
                        break;
                    case 8: //insert at a specific position
                        WriteLine("Enter an integer value to be inserted: ");
                        data = Convert.ToInt32(ReadLine());
                        WriteLine("Enter the position where you want to insert the Node: ");
                        k = Convert.ToInt32(ReadLine());
                        list.InsertAtPosition(data, k);
                        list.DisplayList();
                        break;
                    case 9: //delete the first node
                        list.DeleteFirstNode();
                        WriteLine("First Node deleted");
                        list.DisplayList();
                        break;
                    case 10: //delete the last node
                        list.DeleteLastNode();
                        WriteLine("Last Node deleted");
                        list.DisplayList();
                        break;
                    case 11: //delete a node with a specific value
                        WriteLine("Enter an integer value ot search for and delete: ");
                        data = Convert.ToInt32(ReadLine());
                        list.DeleteNodeWithValue(data);
                        list.DisplayList();
                        break;
                    case 12: //reverse the list
                        list.ReverseList();
                        WriteLine("List reversed.");
                        list.DisplayList();
                        break;
                    case 13: //bubble sort by exchanging data
                        list.BubbleSortData();
                        WriteLine("List sorted.");
                        break;
                    case 14: //bubble sort by exchanging links
                        list.BubbleSortLinks();
                        WriteLine("List sorted.");
                        break;
                    case 15: //insert a cycle
                        WriteLine("Enter an integer value to search for and insert a cycle at: ");
                        data = Convert.ToInt32(ReadLine());
                        list.InsertCycle(data);
                        break;
                    case 16: //detect cycle
                        if (list.FindCycle() != null)
                            WriteLine("Cycle detected at node with value: " + list.FindCycle().data.ToString());
                        else
                            WriteLine("No cycle detected.");
                        break;
                    case 17: //remove cycle
                        list.RemoveCycle();
                        break;
                    case 18: //quit
                        break;
                    default:
                        WriteLine("You chose... poorly");//I see no reason to change this perfectly excellent message to the user
                        break;

                }
            }
        }

        private static int GetMenuChoice()
        {
            int choice;
            WriteLine("");
            WriteLine("1  - Display List");
            WriteLine("2  - Count Nodes");
            WriteLine("3  - Search");
            WriteLine("4  - Insert In Empty List");
            WriteLine("5  - Insert At End");
            WriteLine("6  - Insert After Specified Node");
            WriteLine("7  - Insert Before Specified Node"); 
            WriteLine("8  - Insert At Position");
            WriteLine("9  - Delete First Node");
            WriteLine("10 - Delete Last Node");
            WriteLine("11 - Delete Node with Value");
            WriteLine("12 - Reverse The List");
            WriteLine("13 - Bubble Sort By Exchanging Data");
            WriteLine("14 - Bubble Sort By Exchanging Links");
            WriteLine("15 - Insert Cycle");
            WriteLine("16 - Detect Cycle");
            WriteLine("17 - Remove Cycle");
            WriteLine("18 - Quit");
            WriteLine("You must choose wisely...");
            WriteLine("");
            choice = Convert.ToInt32(ReadLine());
            return choice;
        }
    }
}