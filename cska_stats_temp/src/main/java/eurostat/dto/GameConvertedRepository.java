package eurostat.dto;

import java.util.List;

import javax.persistence.Table;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import eurostat.entities.GameConverted;

@Repository
@Table(name="gameconverted")
public interface GameConvertedRepository extends PagingAndSortingRepository<GameConverted, Integer> {
	
	@Override
	public List<GameConverted> findAll();
	
	@Override
	public List<GameConverted> findAll(Sort sort);

}
