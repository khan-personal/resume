using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace ITDEV154
{
    class SingleLinkedList
    {
        //private member, always points to first node
        private Node start;

        public SingleLinkedList()
        {
            start = null;
        }

        public void CreateList()
        {
            int i, n, data;

            Console.WriteLine("Ender the number of nodes: ");
            n = Convert.ToInt32(ReadLine());

            if (n == 0)
                return;
            for (i = 1; i <= n; i++)
            {
                WriteLine("Enter the element to be inserted: ");
                data = Convert.ToInt32(ReadLine());
                InsertAtEnd(data);
            }
            DisplayList();
        }

        public void InsertAtBeginning(int data)
        {
            Node temp = new Node(data);
            temp.next = start;
            start = temp;
        }

        public void InsertAtEnd(int data)
        {
            Node p;
            Node temp = new Node(data);

            if (start == null) //empty list
            {
                start = temp;
                return;
            }

            p = start;
            while (p.next != null) //walk list to the end
                p = p.next;

            p.next = temp;            
        }

        public void InsertAfter(int data, int x)
        {
            Node p = start;
            while (p != null)
            {
                if (p.data == x)
                    break;
                p = p.next;
            }

            if (p == null)
                WriteLine(x + " is not present in the lsit.");
            else
            {
                Node temp = new Node(data);
                temp.next = p.next;
                p.next = temp;
            }
        }

        public void InsertBefore(int data, int x)
        {
            Node temp;

            //empty list
            if (start == null)
            {
                WriteLine("The List is empty");
            }

            //x is first node
            if (x == start.data)
            {
                InsertAtBeginning(data);
            }

            //get predecessor node
            Node p = start;
            while (p.next != null)
            {
                if (p.next.data == x)
                    break;
                p = p.next;
            }
            if (p.next == null) // didn't find x
            {
                WriteLine(x + " is not present in the lsit.");
            }
            else
            {
                temp = new Node(data);
                temp.next = p.next;
                p.next = temp;
            }
        }

        public void InsertAtPosition(int data, int k)
        {
            Node temp;
            int i;

            if (k == 1)
            {
                InsertAtBeginning(data);
            }

            Node p = start;
            //get a reference to the node prior
            for (i = 1; i < k - 1 && p != null; i++)
                p = p.next;

            if (p == null)
                WriteLine("That position is past the end of the list. \nYou can only insert up to the " + i + "th position");
            else
            {
                temp = new Node(data);
                temp.next = p.next;
                p.next = temp;
            }
        }

        public void DeleteFirstNode()
        {
            if (start == null) //empty list
                return;
            start = start.next;
        }

        public void DeleteLastNode()
        {
            if (start == null)
                return;
            
            if (start.next == null)
            {
                start = null;
                return;
            }

            Node p = start;
            while (p.next.next != null)
                p = p.next;
            p.next = null;
        }

        public void DeleteNodeWithValue(int x)
        {
            if (start == null)
            {
                WriteLine("The list is empty.");
                return;
            }

            //x is found in first node
            if (start.data == x)
            {
                start = start.next;
                return;
                //or... DeleteFirstNode();
            }

            //x is found elsewhere in list
            Node p = start;
            while (p.next != null)
            {
                if (p.next.data == x)
                    break;
                p = p.next;
            }

            if (p.next == null) //not found
                WriteLine(x + " is not found in the list.");
            else
                p.next = p.next.next;
        }

        public void ReverseList()
        { //struggling to wrap my head around this one
            Node previous;
            Node current;
            Node next;

            previous = null;
            current = start;
            while (current != null)
            {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            start = previous;
        }

        public void BubbleSortData()
        {
            Node end, p, q;
            int passCount = 0;

            for (end = null; end != start.next; end = p)
            {
                for (p = start; p.next != end; p = p.next)
                {
                    q = p.next;
                    if (p.data > q.data)
                    {
                        int tempData = p.data;
                        p.data = q.data;
                        q.data = tempData;
                    }
                }
                passCount++;
                WriteLine("List after pass " + passCount);
                DisplayList();
            }
        }

        public void BubbleSortLinks() //confusing
        {
            Node end, r, p, q, temp;
            int passCount = 0;

            for (end = null; end != start.next; end = p)
            {
                for (r = p = start; p.next != end; r = p, p = p.next)
                {
                    q = p.next;
                    if (p.data > q.data)
                    {
                        p.next = q.next;
                        q.next = p;
                        if (p != start)
                            r.next = q;
                        else
                            start = q;

                        temp = p;
                        p = q;
                        q = temp;
                    }
                }
                passCount++;
                WriteLine("List after pass " + passCount);
                DisplayList();
            }
        }

        public bool HasCycle()
        {
            if (FindCycle() != null)
                return true;
            else
                return false;
        }

        public Node FindCycle()
        {
            //empty list or list with only 1 node
            if (start == null || start.next == null)
                return null;

            //create two nodes, 1 fast, 1 slow
            Node tortoise, hare;
            //put them both on the starting line
            tortoise = start;
            hare = start;

            while (hare != null && hare.next != null)
            {
                tortoise = tortoise.next; //move 1
                hare = hare.next.next; //move 2
                if (tortoise == hare) //found cycle
                    return tortoise;
            }

            //didnt find cycle
            return null;
        }

        public void RemoveCycle()
        {
            Node cycleFound = FindCycle();
            if (cycleFound == null)
                return;

            WriteLine("Cycle detected at node with value: " + cycleFound.data);

            //find the length of the cycle
            Node p = cycleFound;
            Node q = cycleFound;

            int cycleLength = 0;

            do
            {
                cycleLength++;
                q = q.next;
            } while (p != q);
            WriteLine("The cycle is " + cycleLength + " nodes long.");

            //find the length of the remaining list
            int remainingListLength = 0;
            p = start;
            while (p != q)
            {
                remainingListLength++;
                p = p.next;
                q = q.next;
            }
            WriteLine("The remaining list is " + remainingListLength + " nodes long.");

            //total list is the sum of the cycle length and the remaining list length
            int listLength = cycleLength + remainingListLength;
            WriteLine("The whole list is " + listLength + " nodes long.");

            //walk the list and reassign next pointer on each node
            p = start;
            for (int i = 1; i <= listLength - 1; i++)
            {
                WriteLine("Reassigning Node:[" + p.data + "].Next -> Node: [" + p.next.data + "]");
                p = p.next;
            }

            //set the next pointer on the last node to be null
            WriteLine("Reassigning Node:[" + p.data + "].Next -> null to terminate list.");
            p.next = null;
            WriteLine("Cycle removed.");
        }

        public void InsertCycle(int x)
        {
            if (start == null)
                return;

            Node p = start;
            Node px = null;
            Node previous = null;

            while (p != null)
            {
                if (p.data == x)
                    px = p;
                previous = p;
                p = p.next;
            }
            if (px != null)
            {
                previous.next = px;
                WriteLine("Cycle inserted at node with value " + x);
            }
            else
                WriteLine(x + " is not present in the list.");
        }// very interesting!

        public void DisplayList()
        {
            if (HasCycle())
            {
                WriteLine("Cycle detected, cannot display list.");
                return;
            }

            Node p;
            if (start == null) //empty list
            {
                WriteLine("List is empty");
                return;
            }
            p = start;
            while (p != null)
            {
                Write(p.data + " ");
                p = p.next;
            }
            WriteLine("");
        }

        public void CountNodes()
        {
            int n = 0;//counter
            Node p = start;
            while (p != null)
            {
                n++;
                p = p.next;
            }
            WriteLine("The list has " + n + " nodes");
        }

        public bool Search(int x)
        {
            int position = 1;
            Node p = start;
            while (p != null)
            {
                if (p.data == x)
                    break;
                position++;
                p = p.next;
            }
            if (p == null)
            {
                WriteLine(x + " not found in the list");
                return false;
            }
            else
            {
                WriteLine(x + " is at position " + position);
                return true;
            }
        }
    }
}
