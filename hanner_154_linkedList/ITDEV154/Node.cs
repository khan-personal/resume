using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ITDEV154
{
    internal class Node
    {
        //members
        public int data;
        public Node next;

        //constructor
        public Node(int i)
        {
            data = i;
            next = null;
        }
    }
}
