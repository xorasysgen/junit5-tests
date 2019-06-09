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
* @Test Denotes that a method is a test method. Unlike JUnit 4�s @Test annotation, this annotation does not declare any attributes, since test extensions in JUnit Jupiter operate based on their own dedicated annotations. Such methods are inherited unless they are overridden.
* @ParameterizedTest Denotes that a method is a parameterized test. Such methods are inherited unless they are overridden.
* @RepeatedTest Denotes that a method is a test template for a repeated test. Such methods are inherited unless they are overridden.
* @TestFactory Denotes that a method is a test factory for dynamic tests. Such methods are inherited unless they are overridden.
* @TestTemplate Denotes that a method is a template for test cases designed to be invoked multiple times depending on the number of invocation contexts returned by the registered providers. Such methods are inherited unless they are overridden.
* @TestMethodOrder Used to configure the test method execution order for the annotated test class; similar to JUnit 4�s @FixMethodOrder. Such annotations are inherited.
* @TestInstance Used to configure the test instance lifecycle for the annotated test class. Such annotations are inherited.
* @DisplayName Declares a custom display name for the test class or test method. Such annotations are not inherited.
* @DisplayNameGeneration Declares a custom display name generator for the test class. Such annotations are inherited.
* @BeforeEach Denotes that the annotated method should be executed before each @Test, @RepeatedTest, @ParameterizedTest, or @TestFactory method in the current class; analogous to JUnit 4�s @Before. Such methods are inherited unless they are overridden.
* @AfterEach Denotes that the annotated method should be executed after each @Test, @RepeatedTest, @ParameterizedTest, or @TestFactory method in the current class; analogous to JUnit 4�s @After. Such methods are inherited unless they are overridden.
* @BeforeAll Denotes that the annotated method should be executed before all @Test, @RepeatedTest, @ParameterizedTest, and @TestFactory methods in the current class; analogous to JUnit 4�s @BeforeClass. Such methods are inherited (unless they are hidden or overridden) and must be static (unless the "per-class" test instance lifecycle is used).
* @AfterAll Denotes that the annotated method should be executed after all @Test, @RepeatedTest, @ParameterizedTest, and @TestFactory methods in the current class; analogous to JUnit 4�s @AfterClass. Such methods are inherited (unless they are hidden or overridden) and must be static (unless the "per-class" test instance lifecycle is used).
* @Nested Denotes that the annotated class is a non-static nested test class. @BeforeAll and @AfterAll methods cannot be used directly in a @Nested test class unless the "per-class" test instance lifecycle is used. Such annotations are not inherited.
* @Tag Used to declare tags for filtering tests, either at the class or method level; analogous to test groups in TestNG or Categories in JUnit 4. Such annotations are inherited at the class level but not at the method level.
* @Disabled Used to disable a test class or test method; analogous to JUnit 4�s @Ignore. Such annotations are not inherited.
* @ExtendWith Used to register extensions declaratively. Such annotations are inherited.
* @RegisterExtension Used to register extensions programmatically via fields. Such fields are inherited unless they are shadowed.
* @TempDir Used to supply a temporary directory via field injection or parameter injection in a lifecycle method or test method; located in the org.junit.jupiter.api.io package.


# Reference
* https://junit.org/junit5/docs/current/user-guide/