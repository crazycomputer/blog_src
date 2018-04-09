/**  
 * @Title: ParentTypeServiceImpl.java  
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

import top.gn.dao.ParentTypeDAO;
import top.gn.entity.BlogParentType;
import top.gn.service.ParentTypeService;

/**  
 * @ClassName: ParentTypeServiceImpl  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author BoyHu
 * @date 6 Apr 2018  
 *    
 */
@Service
public class ParentTypeServiceImpl implements ParentTypeService {

	
	private ParentTypeDAO parentTypeDAOImpl;
	
	@Autowired
	public void setParentTypeDAOImpl(ParentTypeDAO parentTypeDAOImpl) {
		this.parentTypeDAOImpl = parentTypeDAOImpl;
	}
	
	@Override
	public List<BlogParentType> getParentTypeAll() {
		try {
			return this.parentTypeDAOImpl.getAll();
		} catch (SQLException e) {
			System.out.println("异常 : 查询所有一级(父)分类失败 ");
			e.printStackTrace();
		}
		return null;
	}

}
