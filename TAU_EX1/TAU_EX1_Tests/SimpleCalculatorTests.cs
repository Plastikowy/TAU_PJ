using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using TAU_EX1;

namespace TAU_EX1_Tests
{
    [TestFixture]
    public class SimpleCalculatorTests
    {
        private SimpleCalculator calculator; 

        [SetUp]
        public void SetUp()
        {
            calculator = new SimpleCalculator();
        }

        [Test]
        public void CheckIfCalculatorIsNotNull()
        {
            Assert.IsNotNull(calculator);
        }

        [Test]
        public void CheckCantDivideByZero()
        {
            calculator = new SimpleCalculator(2, 0);

            Assert.Throws<ArgumentException>(() =>
            {
                calculator.Divide();
            });
        }

        [Test]
        public void CanSetNumber1()
        {
            calculator.Number1 = 1;

            Assert.AreEqual(calculator.Number1, 1);
        }

        [Test]
        public void CanSetNumber2()
        {
            calculator.Number2 = 2;

            Assert.AreEqual(calculator.Number2, 2);
        }

        [Test]
        public void CheckAddResultCorrect()
        {
            calculator = new SimpleCalculator(2, 2);
            float result = calculator.Add();

            Assert.AreEqual(result, 4);
        }

        [Test]
        public void CheckSubstractResultCorrect()
        {
            calculator = new SimpleCalculator(2, 2);
            float result = calculator.Substract();

            Assert.AreEqual(result, 0);
        }

        [Test]
        public void CheckDivideResultCorrect()
        {
            calculator = new SimpleCalculator(2, 2);
            float result = calculator.Divide();

            Assert.AreEqual(result, 1);
        }

        [Test]
        public void CheckMultiplyResultCorrect()
        {
            calculator = new SimpleCalculator(2, 2);
            float result = calculator.Multiply();

            Assert.AreEqual(result, 4);
        }

        [Test]
        public void CheckCalculatorInstanceNotChange()
        {
            calculator.Number1 = 2;
            calculator.Number2 = 4;

            calculator.Add();

            SimpleCalculator ein = calculator;

            calculator.Number1 = 5;
            calculator.Number2 = 5;

            calculator.Multiply();

            SimpleCalculator zwei = calculator;

            Assert.AreEqual(ein, zwei);
        }

        [Test]
        public void ResultsDiffersPerOperation()
        {
            calculator.Number1 = 2;
            calculator.Number2 = 4;

            float res1 = calculator.Add();

            calculator.Number1 = 5;
            calculator.Number2 = 5;

            float res2 = calculator.Multiply();

            Assert.AreNotEqual(res1, res2);
        }
    }
}
