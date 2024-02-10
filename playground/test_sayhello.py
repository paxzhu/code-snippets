import unittest
from hello import sayhello

class SayHelloTestCase(unittest.TestCase):

    def setUp(self):
        pass

    def tearDown(self) -> None:
        pass

    def test_sayhello(self):
        return_value = sayhello()
        return self.assertEqual(return_value, 'Hello')
    
    def test_sayhello_to_someone(self):
        return_value = sayhello('paxzhu')
        return self.assertEqual(return_value, 'Hello, paxzhu')
    
if __name__ == '__main__':
    unittest.main()