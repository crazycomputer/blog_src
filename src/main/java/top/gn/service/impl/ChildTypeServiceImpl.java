/**  
 * @Title: ChildTypeServiceImpl.java  
 * @Package top.gn.service.impl 
 * @author BoyHu  
 * @date 6 Apr 2018  
 * @version V1.0  
 */  
package top.gn.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.gn.dao.ChildTypeDAO;
import top.gn.entity.BlogChildType;
import top.gn.service.ChildTypeService;

/**  
 * @ClassName: ChildTypeServiceImpl  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author BoyHu
 * @date 6 Apr 2018  
 *    
 */
@Service
public class ChildTypeServiceImpl implements ChildTypeService {

	
	private ChildTypeDAO childTypeDAOImpl ;
	
	@Autowired
	public void setChildTypeDAOImpl(ChildTypeDAO childTypeDAOImpl) {
		this.childTypeDAOImpl = childTypeDAOImpl;
	}
	
	@Override
	public List<BlogChildType> getChildTypeAll() {
		try {
			return this.childTypeDAOImpl.getAll();
		} catch (SQLException e) {
			System.err.println("异常: 查询所有子分类失败 ");
			e.printStackTrace();
		}
		return null;
	}

}
