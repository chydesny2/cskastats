package eurostat.dto;

import javax.persistence.Table;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import eurostat.entities.Authority;


@Repository
@Table(name="authorities")
public interface AuthorityRepository extends PagingAndSortingRepository<Authority, Long>{

}
