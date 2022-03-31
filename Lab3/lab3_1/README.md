## a) Identify a couple of examples on the use of AssertJ expressive methods chaining.

### A_EmployeeRepositoryTest:
    assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());

### B_EmployeeService_UnitTest:
    assertThat(allEmployees).hasSize(3).extracting(Employee::getName).contains(alex.getName(), john.getName(), bob.getName());
    
### D_EmployeeRestControllerIT:
    assertThat(found).extracting(Employee::getName).containsOnly("bob");

### E_EmployeeRestControllerTemplateIT:
    assertThat(found).extracting(Employee::getName).containsOnly("bob");    
    assertThat(response.getBody()).extracting(Employee::getName).containsExactly("bob", "alex");

## b) Identify an example in which you mock the behavior of the repository (and avoid involving a database). 

### B_EmployeeService_UnitTest:

    @Mock( lenient = true)
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {

        //these expectations provide an alternative to the use of the repository
        Employee john = new Employee("john", "john@deti.com");
        john.setId(111L);

        Employee bob = new Employee("bob", "bob@deti.com");
        Employee alex = new Employee("alex", "alex@deti.com");

        List<Employee> allEmployees = Arrays.asList(john, bob, alex);

        Mockito.when(employeeRepository.findByName(john.getName())).thenReturn(john);
        Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);
        Mockito.when(employeeRepository.findByName("wrong_name")).thenReturn(null);
        Mockito.when(employeeRepository.findById(john.getId())).thenReturn(Optional.of(john));
        Mockito.when(employeeRepository.findAll()).thenReturn(allEmployees);
        Mockito.when(employeeRepository.findById(-99L)).thenReturn(Optional.empty());
    }

## c) What is the difference between standard @Mock and @MockBean?

@Mock is a shorthand for the Mockito.mock(), while @MockBean is used in a SpringBoot environments to mock beans.

## d) What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?

The file "application-integrationtest.properties" contains the details to have a persistent storage.
It will be used when the anotation @TestPropertySource is used before a test class, for example in EmployeeRestControllerIT.

## e) the sample project demonstrates three test strategies to assess an API (C, D and E)developed with SpringBoot.Which are the main/key differences?

In C we access the API through a mock service to test the controller behavier. In D and E we access the API with the rest controller, but in D we don't test the Client API while in E we test the REST API.

### C_EmployeeController_ WithMockServiceTest:

    @Autowired
    private MockMvc mvc;    //entry point to the web framework

    // inject required beans as "mockeable" objects
    // note that @AutoWire would result in NoSuchBeanDefinitionException
    @MockBean
    private EmployeeService service;


    @BeforeEach
    public void setUp() throws Exception {
    }

### D_EmployeeRestControllerIT:

    @Autowired
    private MockMvc mvc;

    @Autowired
    private EmployeeRepository repository;

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }

### E_EmployeeRestControllerTemplateIT:

    @LocalServerPort
    int randomServerPort;

    // a REST client that is test-friendly
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EmployeeRepository repository;

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }