package se.jensen.project.employee.entity;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import se.jensen.project.common.entity.EntityID;

@SuperBuilder
@EqualsAndHashCode
public class EmployeeID extends EntityID<Integer> {
}
