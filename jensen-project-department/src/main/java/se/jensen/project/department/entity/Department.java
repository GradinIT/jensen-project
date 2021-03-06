package se.jensen.project.department.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Builder
@Getter
@EqualsAndHashCode(cacheStrategy= EqualsAndHashCode.CacheStrategy.LAZY)
@ToString
public class Department {
    private final @NonNull DepartmentId departmentId;
    private final @NonNull String departmentName;
}
