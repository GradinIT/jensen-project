package se.jensen.project.department.entity;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import se.jensen.project.common.entity.EntityID;

@SuperBuilder
@EqualsAndHashCode
public class DepartmentId extends EntityID<Integer> {
}
