package com.avangenio.firstex;

@RunWith(SpringRunner.class)
@SpringBootTest(
  SpringBootTest.WebEnvironment.MOCK,
  classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application-integrationtest.properties")
public class SectionTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private EmployeeRepository repository;



    @Test
	public void givenEmployees_whenGetEmployees_thenStatus200()
			throws Exception {

		createTestEmployee("bob");

		mvc.perform(get("/api/employees")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name", is("bob")));
	}
    
}
