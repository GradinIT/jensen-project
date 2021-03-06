package se.jensen.project.department.integrationtest;

import com.google.gson.Gson;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import se.jensen.project.TestRestServiceApplication;
import se.jensen.project.department.api.DepartmentModel;
import se.jensen.project.department.test.config.LiquibaseTestConfigurer;
import se.jensen.project.department.test.config.PersistenceTestConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CucumberContextConfiguration
@SpringBootTest(classes = {TestRestServiceApplication.class, LiquibaseTestConfigurer.class, PersistenceTestConfig.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DepartmentTestClient {
    private static final String BASE_URL = "http://localhost:8080/";
    private static final Gson gson = new Gson().newBuilder().setPrettyPrinting().create();

    public static Optional<List<DepartmentModel>> getAllDepartments() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.exchange(BASE_URL+"department/",
                HttpMethod.GET,
                null,
                List.class);
        List list = (List) responseEntity.getBody();
        List<DepartmentModel> departmentModels = new ArrayList<>();
        list.stream().forEach(o -> {
            departmentModels.add(gson.fromJson(o.toString(), DepartmentModel.class));
        });
        return Optional.ofNullable(departmentModels);

    }

    public static Optional<DepartmentModel> getDepartmentById(Integer departmentId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.exchange(BASE_URL+"department/" + departmentId,
                HttpMethod.GET,
                null,
                DepartmentModel.class);
        return Optional.ofNullable(DepartmentModel.class.cast(responseEntity.getBody()));

    }

    public static Optional<DepartmentModel> updateDepartment(DepartmentModel departmentModel) {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<DepartmentModel> requestEntity = new RequestEntity<DepartmentModel>(departmentModel, HttpMethod.PUT, null);
        ResponseEntity<DepartmentModel> response = restTemplate.exchange(BASE_URL+"department/", HttpMethod.PUT, requestEntity, DepartmentModel.class);
        return Optional.of(response.getBody());
    }

    public static Optional<DepartmentModel> createDepartment(DepartmentModel departmentModel) {
        RestTemplate restTemplate = new RestTemplate();
        DepartmentModel result = restTemplate.postForObject(BASE_URL+"department/", departmentModel, DepartmentModel.class);
        return Optional.of(result);
    }

    public static Optional<DepartmentModel> deleteDepartment(DepartmentModel departmentModel) {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<DepartmentModel> requestEntity = new RequestEntity<DepartmentModel>(departmentModel, HttpMethod.DELETE,
                null);
        DepartmentModel result = restTemplate.exchange(BASE_URL+"department/", HttpMethod.DELETE, requestEntity, DepartmentModel.class).getBody();
        return Optional.of(result);

    }
}
