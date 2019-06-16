In this tutorial, I’ll cover the annotations of the Mockito library – @Mock, @Spy, @Captor, and @InjectMocks.

1. Enable Mockito Annotations
First – let’s see how to enable the use of annotations with Mockito tests.

In order for these annotations to be enabled, we’ll need to annotate the JUnit test with a runner – MockitoJUnitRunner as in the following example:
Refer - /example-mockito/src/test/java/learning/MockitoAnnotationTest.java

Alternatively, we can enable these annotations programmatically as well, by invoking MockitoAnnotations.initMocks() as in the following example:
Refer - /example-mockito/src/test/java/learning/MockitoAnnotationWithInitMock.java

3. @Mock Annotation

The most used widely used annotation in Mockito is @Mock. We can use @Mock to create and inject mocked instances without having to call Mockito.mock manually.

In the following example – I’ll create a mocked ArrayList with the manual way without using @Mock annotation:
Refer : /example-mockito/src/test/java/learning/ManualWayWithOutMockExample.java

And now we’ll do the same but we’ll inject the mock using the @Mock annotation:
refer : /example-mockito/src/test/java/learning/MockExample.java

Note how – in both examples, we’re interacting with the mock and verifying some of these interactions – just to make sure that the mock is behaving correctly.

4. @Spy Annotation

Now – let’s see how to use @Spy annotation to spy on an existing instance.

In the following example – we create a spy of a List with the old way without using @Spy annotation:
/example-mockito/src/test/java/learning/SpyOldWay.java

Let’s now do the same – spy on the list – but do so using the @Spy annotation:
/example-mockito/src/test/java/learning/SpyMock.java

Note how, as before – we’re interacting with the spy here to make sure that it behaves correctly. In this example we:

    Used the real method spiedList.add() to add elements to the spiedList.
    Stubbed the method spiedList.size() to return 100 instead of 2 using Mockito.doReturn().

5. @Captor Annotation

Next – let’s see how to use the @Captor annotation to create an ArgumentCaptor instance.

In the following example – we create an ArgumentCaptor with the old way without using @Captor annotation:
/example-mockito/src/test/java/learning/CaptorOldWay.java

Let’s now make use of @Captor for the same purpose – to create an ArgumentCaptor instance:
/example-mockito/src/test/java/learning/CaptorMockWay.java

Notice how the test becomes simpler and more readable when we take out the configuration logic.


6. @InjectMocks Annotation

Now – let’s discuss how to use @InjectMocks annotation – to inject mock fields into the tested object automatically.

In the following example – we use @InjectMocks to inject the mock wordMap into the MyDictionary dic:


Useful Links:

https://www.baeldung.com/mockito-annotations
https://www.tutorialspoint.com/mockito/mockito_useful_resources.htm
https://site.mockito.org/
https://github.com/mockito/mockito/wiki/What%27s-new-in-Mockito-2
https://www.vogella.com/tutorials/Mockito/article.html