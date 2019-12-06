# Leather programming language
A small compiled programming language developped by Étienne Plante
**&lt;&gt;::=** &lt;&gt;
### Grammar

------------

**&lt;program&gt;::=** &lt;variable-declaration&gt; | &lt;function-declaration&gt;
**&lt;statement&gt;::=** &lt;variable-declaration&gt;
**&lt;variable-declaration&gt;::=** &lt;variable-keyword&gt; : &lt;variable-type&gt; &lt;identifier&gt; = &lt;variable-body&gt; ;
**&lt;identifier&gt;::=** 1\*&lt;letter&gt;
**&lt;variable-body&gt;::=** &lt;letter&gt; | &lt;number&gt; | &lt;boolean&gt;
**&lt;function-declaration&gt;::=** &lt;function-keyword&gt; : &lt;data-type&gt; ( { &lt;argument&gt; } ) { {&lt;statement&gt;} }
**&lt;argument&gt;::=** &lt;variable-keyword&gt; : &lt;data-type&gt; &lt;identifier&gt; {"," &lt;argument&gt;}
**&lt;variable-keyword&gt;::=** var
**&lt;function-keyword&gt;::=** func
**&lt;data-type&gt;::=** int | bool | char
**&lt;letter&gt;::=** [a-zA-Z]+
**&lt;number&gt;::=** [0-9]+

## Examples of working programs
### Hello world

    link entry main()
    
    func:void main()
    {
    	Console.print("Hello world");
    }

### Basic variable and function declaration
    //main function implied in all following examples
    var:int a = 10;   
    var:int b;
    b = 10;
    var:char c = 'b';
    var d = 10;
    d = 'd';
	
	func:returnNumber(int num)
	{
		out num;
	}
	
### Basic function calling
    printMessage("Hello world");
    var:int addition = add(2, 5); //additition is initialized with the out value of add
	
### Fizz Buzz
    func:void fizzbuzz(int n)
    {
    	for i in (0, n) with 1
    	{
    		if i % 3 == 0 && i % 5 == 0
    		{
    			Console.print("FizzBuzz")
    		}
    		elseif i % 3 == 0
    		{
    			Console.print("Fizz")
    		}
    		elseif i % 5 == 0
    		{
    			Console.print("Buzz")
    		}
    	}
    }