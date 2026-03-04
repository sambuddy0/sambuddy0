package cs3220.repository;

import org.springframework.data.repository.CrudRepository;

import cs3220.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
