package crazy.jdbc;

/**
 * 使用JdbcTemplate中的PreparedStatement对SQL进行注入防范的使用方法。
 * @author i324779
 *
 */
public class JdbcTemplateSample {
    /*
    public Pagination getUsers(User user, String ip, int pageNo, int pageSize) {
    	StringBuffer sql = new StringBuffer(
    		"SELECT d.*,group_name from jc_group c , (SELECT a.user_id as id,a.username,a.email,a.foreign_num as isForeignNum,a.user_group_level,a.group_id,b.last_login_time as ltime,b.login_count as lcount,b.register_ip as rip,b.last_login_ip as lip, a.is_disabled FROM ac_user a ,ac_user_manage_ext b where a.user_id=b.user_id ");
    	List<Object> parameters = new ArrayList<>();
    	if (user != null) {
    	    if (user.getId() > 0) {
    		sql.append(" and a.user_id= ?");
    		parameters.add(user.getId());
    	    }
    	    if (!Strings.isNullOrEmpty(user.getUsername())) {
    		sql.append(" and a.username like ?");
    		parameters.add("%" + user.getUsername() + "%");
    	    }
    	    if (!Strings.isNullOrEmpty(user.getEmail())) {
    		sql.append(" and a.email like ?");
    		parameters.add("%" + Strings.nullToEmpty(user.getEmail()).trim() + "%");
    	    }
    	    if (user.getInviter() != null) {
    		sql.append(" and a.inviter= ?");
    		parameters.add(user.getInviter());
    	    }
    	    if (!user.getIsAdmin()) {
    		sql.append(" and a.is_admin= ?");
    		parameters.add(user.getIsAdmin());
    	    }
    	    if (!Strings.isNullOrEmpty(user.getMobile())) {
    		sql.append(" and a.mobile like ?");
    		parameters.add(user.getMobile() + "%");
    	    }
    	    if (user.getIsForeignNum() != null) {
    		sql.append(" and a.foreign_num= ?");
    		parameters.add(user.getIsForeignNum());
    	    }
    	    if (!Strings.isNullOrEmpty(ip)) {
    		sql.append(" and (b.register_ip like ?");
    		sql.append(" or b.last_login_ip like ?");
    		parameters.add(ip + "%");
    		parameters.add(ip + "%");
    		sql.append(")");
    	    }
    	}
    
    	sql.append(" order by b.user_id desc");
    	sql.append(" limit " + (pageNo - 1) * pageSize + "," + pageSize);
    	sql.append(") d where c.group_id=d.group_id order by d.id desc");
    
    	// 慢查询修改为从库查询
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    
    	List<User> users = jdbcTemplate.query(sql.toString(), ps -> {
    	    for (int i = 0; i < parameters.size(); i++) {
    		ps.setObject(i + 1, parameters.get(i));
    	    }
    	}, new BeanPropertyRowMapper<>(User.class));
    }
    */
}
