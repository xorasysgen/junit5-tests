# JUnit 5

JUnit 5 is composed of several different modules from three different sub-projects.
## JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage
* JUnit Platform -> The JUnit Platform serves as a foundation for launching testing frameworks on the JVM. It also defines the TestEngine API for developing a testing framework that runs on the platform.
* JUnit Jupiter -> JUnit Jupiter is the combination of the new programming model and extension model for writing tests and extensions in JUnit 5. The Jupiter sub-project provides a TestEngine for running Jupiter based tests on the platform.
* JUnit Vintage -> JUnit Vintage provides a TestEngine for running JUnit 3 and JUnit 4 based tests on the platform.


# Rules
* Test Class: Any top-level class, static member class, or @Nested class that contains at least one test method.<br>
Test classes must not be abstract and must have a single constructor.
* Test Method: any instance method that is directly annotated or meta-annotated with @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, or @TestTemplate.
* Lifecycle Method: any method that is directly annotated or meta-annotated with @BeforeAll, @AfterAll, @BeforeEach, or @AfterEach.



# Annotation Description
* @Test Denotes that a method is a test method. Unlike JUnit 4’s @Test annotation, this annotation does not declare any attributes, since test extensions in JUnit Jupiter operate based on their own dedicated annotations. Such methods are inherited unless they are overridden.
* @ParameterizedTest Denotes that a method is a parameterized test. Such methods are inherited unless they are overridden.
* @RepeatedTest Denotes that a method is a test template for a repeated test. Such methods are inherited unless they are overridden.
* @TestFactory Denotes that a method is a test factory for dynamic tests. Such methods are inherited unless they are overridden.
* @TestTemplate Denotes that a method is a template for test cases designed to be invoked multiple times depending on the number of invocation contexts returned by the registered providers. Such methods are inherited unless they are overridden.
* @TestMethodOrder Used to configure the test method execution order for the annotated test class; similar to JUnit 4’s @FixMethodOrder. Such annotations are inherited.
* @TestInstance Used to configure the test instance lifecycle for the annotated test class. Such annotations are inherited.
* @DisplayName Declares a custom display name for the test class or test method. Such annotations are not inherited.
* @DisplayNameGeneration Declares a custom display name generator for the test class. Such annotations are inherited.
* @BeforeEach Denotes that the annotated method should be executed before each @Test, @RepeatedTest, @ParameterizedTest, or @TestFactory method in the current class; analogous to JUnit 4’s @Before. Such methods are inherited unless they are overridden.
* @AfterEach Denotes that the annotated method should be executed after each @Test, @RepeatedTest, @ParameterizedTest, or @TestFactory method in the current class; analogous to JUnit 4’s @After. Such methods are inherited unless they are overridden.
* @BeforeAll Denotes that the annotated method should be executed before all @Test, @RepeatedTest, @ParameterizedTest, and @TestFactory methods in the current class; analogous to JUnit 4’s @BeforeClass. Such methods are inherited (unless they are hidden or overridden) and must be static (unless the "per-class" test instance lifecycle is used).
* @AfterAll Denotes that the annotated method should be executed after all @Test, @RepeatedTest, @ParameterizedTest, and @TestFactory methods in the current class; analogous to JUnit 4’s @AfterClass. Such methods are inherited (unless they are hidden or overridden) and must be static (unless the "per-class" test instance lifecycle is used).
* @Nested Denotes that the annotated class is a non-static nested test class. @BeforeAll and @AfterAll methods cannot be used directly in a @Nested test class unless the "per-class" test instance lifecycle is used. Such annotations are not inherited.
* @Tag Used to declare tags for filtering tests, either at the class or method level; analogous to test groups in TestNG or Categories in JUnit 4. Such annotations are inherited at the class level but not at the method level.
* @Disabled Used to disable a test class or test method; analogous to JUnit 4’s @Ignore. Such annotations are not inherited.
* @ExtendWith Used to register extensions declaratively. Such annotations are inherited.
* @RegisterExtension Used to register extensions programmatically via fields. Such fields are inherited unless they are shadowed.
* @TempDir Used to supply a temporary directory via field injection or parameter injection in a lifecycle method or test method; located in the org.junit.jupiter.api.io package.


# Test Lifecycle Callbacks
The following interfaces define the APIs for extending tests at various points in the test execution lifecycle
```js
BeforeAllCallback
	BeforeEachCallback
		BeforeTestExecutionCallback
		AfterTestExecutionCallback
	AfterEachCallback
AfterAllCallback
```

JUnit Jupiter always guarantees wrapping behavior for multiple registered extensions that implement lifecycle callbacks such as BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback, BeforeTestExecutionCallback, and AfterTestExecutionCallback.

That means that, given two extensions Extension1 and Extension2 with Extension1 registered before Extension2, any "before" callbacks implemented by Extension1 are guaranteed to execute before any "before" callbacks implemented by Extension2. Similarly, given the two same two extensions registered in the same order, any "after" callbacks implemented by Extension1 are guaranteed to execute after any "after" callbacks implemented by Extension2. Extension1 is therefore said to wrap Extension2.

JUnit Jupiter also guarantees wrapping behavior within class and interface hierarchies for user-supplied lifecycle methods (see Test Classes and Methods).

@BeforeAll methods are inherited from superclasses as long as they are not hidden or overridden. Furthermore, @BeforeAll methods from superclasses will be executed before @BeforeAll methods in subclasses.

Similarly, @BeforeAll methods declared in an interface are inherited as long as they are not hidden or overridden, and @BeforeAll methods from an interface will be executed before @BeforeAll methods in the class that implements the interface.

@AfterAll methods are inherited from superclasses as long as they are not hidden or overridden. Furthermore, @AfterAll methods from superclasses will be executed after @AfterAll methods in subclasses.

Similarly, @AfterAll methods declared in an interface are inherited as long as they are not hidden or overridden, and @AfterAll methods from an interface will be executed after @AfterAll methods in the class that implements the interface.

@BeforeEach methods are inherited from superclasses as long as they are not overridden. Furthermore, @BeforeEach methods from superclasses will be executed before @BeforeEach methods in subclasses.

Similarly, @BeforeEach methods declared as interface default methods are inherited as long as they are not overridden, and @BeforeEach default methods will be executed before @BeforeEach methods in the class that implements the interface.

@AfterEach methods are inherited from superclasses as long as they are not overridden. Furthermore, @AfterEach methods from superclasses will be executed after @AfterEach methods in subclasses.

Similarly, @AfterEach methods declared as interface default methods are inherited as long as they are not overridden, and @AfterEach default methods will be executed after @AfterEach methods in the class that implements the interface.

```html
Step	Interface/Annotation	Description
1 interface org.junit.jupiter.api.extension.BeforeAllCallback
	extension code executed before all tests of the container are executed
2 annotation org.junit.jupiter.api.BeforeAll
	user code executed before all tests of the container are executed
3 interface org.junit.jupiter.api.extension.BeforeEachCallback
	extension code executed before each test is executed
4 annotation org.junit.jupiter.api.BeforeEach
	user code executed before each test is executed
5 interface org.junit.jupiter.api.extension.BeforeTestExecutionCallback
	extension code executed immediately before a test is executed
6 annotation org.junit.jupiter.api.Test
	user code of the actual test method
7 interface org.junit.jupiter.api.extension.TestExecutionExceptionHandler
	extension code for handling exceptions thrown during a test
8 interface org.junit.jupiter.api.extension.AfterTestExecutionCallback
	extension code executed immediately after test execution and its corresponding exception handlers
9 annotation org.junit.jupiter.api.AfterEach
	user code executed after each test is executed
10 interface org.junit.jupiter.api.extension.AfterEachCallback
	extension code executed after each test is executed
11 annotation org.junit.jupiter.api.AfterAll
	user code executed after all tests of the container are executed
12 interface org.junit.jupiter.api.extension.AfterAllCallback
	extension code executed after all tests of the container are executed
```


# Reference
* https://junit.org/junit5/docs/current/user-guide/
