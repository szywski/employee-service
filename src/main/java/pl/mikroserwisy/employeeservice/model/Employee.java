package pl.mikroserwisy.employeeservice.model;

public record Employee(Long id, Long backofficeId, String name, int age, String position) {
}
