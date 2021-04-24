package eurostat.dto;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import eurostat.dao.PlayerStatDate;


@Repository
public interface PlayerStatDateRepository extends PagingAndSortingRepository<PlayerStatDate, Long>{
	public List<PlayerStatDate> findByUserName(String userName);
	public PlayerStatDate findByPlayerStatDateId(long playerStatDateId);
	
}
