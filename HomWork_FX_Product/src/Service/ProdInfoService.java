package Service;

import java.util.List;
import java.util.Map;

import Vo.LprodVO;
import Vo.ProdVO;



public interface ProdInfoService {
	List<ProdVO> getSearchData(Map<String, String> map);

	List<LprodVO> getLpName();

	List<ProdVO> getPlist(String lpName);

}
