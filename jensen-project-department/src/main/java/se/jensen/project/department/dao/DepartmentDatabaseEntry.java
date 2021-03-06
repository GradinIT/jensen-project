package se.jensen.project.department.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "DEPARTMENT")
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDatabaseEntry {
    @Id
    private @NonNull Integer departmentId;
    private @NonNull String departmentName;
}
