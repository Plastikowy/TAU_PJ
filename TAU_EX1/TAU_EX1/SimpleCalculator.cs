using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TAU_EX1
{
    public class SimpleCalculator
    {
        private float number1;
        private float number2;
        private float result;

        public float Number1 { get => number1; set => number1 = value; }
        public float Number2 { get => number2; set => number2 = value; }
        public float Result { get => result; private set => result = value; }

        public SimpleCalculator(float number1, float number2)
        {
            this.number1 = number1;
            this.number2 = number2;
        }

        public SimpleCalculator()
        {
        }

        public float Add()
        {
            result = number1 + number2;
            return result;
        }

        public float Substract()
        {
            result = number1 - number2;
            return result;
        }

        public float Divide()
        {
            if (number1 == 0 || number2 == 0)
                throw new ArgumentException("You can't divide by 0");

            result = number1 / number2;
            return result;
        }

        public float Multiply()
        {
            result = number1 * number2;
            return result;
        }
    }
}
