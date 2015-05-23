package com.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDao<T> extends HibernateDaoSupport {

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		if (this.clazz == null) {
			Class<T> clazz = (Class<T>) getClass();
			ParameterizedType type = (ParameterizedType) clazz
					.getGenericSuperclass();
			this.clazz = (Class<T>) type.getActualTypeArguments()[0];
		}
	}

	/**
	 * 根据sql语句进行查询
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            sql语句中的参数，如果没有参数则传入一个null
	 * @param paramTypes
	 *            sql语句中参数对应的值，如果没有参数则传入一个null
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> queryBySql(final String sql, final List<Object> params,
			final List<Type> paramTypes) {
		return (List<T>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {
						SQLQuery query = session.createSQLQuery(sql);
						query.addEntity(clazz);
						if (params != null && !params.isEmpty()) {
							query.setParameters(params.toArray(), paramTypes
									.toArray(new Type[paramTypes.size()]));
						}
						return (List<T>) query.list();
					}
				});
	}
	
	
	public List queryBySql(final String sql) {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {
						SQLQuery query = session.createSQLQuery(sql);
						return (List<T>) query.list();
					}
				});
	}

	/**
	 * 查询一页的数据，
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            sql语句中的参数，如果没有参数则传入一个null
	 * @param paramTypes
	 *            sql语句中参数对应的值，如果没有参数则传入一个null
	 * @param pageNo
	 *            第几页
	 * @param pageSize
	 *            一页显示的记录数量
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> queryBySql(final String sql, final List<Object> params,
			final List<Type> paramTypes, final int pageNo, final int pageSize) {
		return (List<T>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {

						SQLQuery query = session.createSQLQuery(sql);
						query.addEntity(clazz);
						if (params != null && !params.isEmpty()) {
							query.setParameters(params.toArray(), paramTypes
									.toArray(new Type[paramTypes.size()]));
						}
						query.setFirstResult((pageNo - 1) * pageSize)
								.setMaxResults(pageSize);
						return (List<T>) query.list();
					}
				});
	}

	/**
	 * 查询返回单条数据，如总行数
	 * 
	 * @param sql
	 *            sql查询语句
	 * @param params
	 *            sql语句中的参数，如果没有参数则传入一个null
	 * @param paramTypes
	 *            sql语句中参数对应的值，如果没有参数则传入一个nul
	 * @return 返回单条数据
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object queryCountBySql(final String sql, final List<Object> params,
			final List<Type> paramTypes) {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(clazz);
				if (params != null && !params.isEmpty()) {
					query.setParameters(params.toArray(),
							paramTypes.toArray(new Type[paramTypes.size()]));
				}
				return query.uniqueResult();
			}
		});
	}

	/**
	 * 根据hql语句进行查询
	 * 
	 * @param hql
	 *            hql语句
	 * @param params
	 *            hql语句中的参数，如果没有参数则传入一个null
	 * @param paramTypes
	 *            hql语句中参数对应的值，如果没有参数则传入一个null
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> queryByHql(final String hql, final List<Object> params,
			final List<Type> paramTypes) {
		return (List<T>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (params != null && !params.isEmpty()) {
							query.setParameters(params.toArray(), paramTypes
									.toArray(new Type[paramTypes.size()]));
						}
						return (List<T>) query.list();
					}
				});
	}

	/**
	 * 查询一页的数据，
	 * 
	 * @param hql
	 *            hql语句
	 * @param params
	 *            hql语句中的参数，如果没有参数则传入一个null
	 * @param paramTypes
	 *            hql语句中参数对应的值，如果没有参数则传入一个null
	 * @param pageNo
	 *            第几页
	 * @param pageSize
	 *            一页显示的记录数量
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> queryByHql(final String hql, final List<Object> params,
			final List<Type> paramTypes, final int pageNo, final int pageSize) {
		return (List<T>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {

						Query query = session.createQuery(hql);

						if (params != null && !params.isEmpty()) {
							query.setParameters(params.toArray(), paramTypes
									.toArray(new Type[paramTypes.size()]));
						}
						query.setFirstResult((pageNo - 1) * pageSize)
								.setMaxResults(pageSize);
						return (List<T>) query.list();
					}
				});
	}

	/**
	 * 查询返回单条数据，如总行数
	 * 
	 * @param hql
	 *            hql查询语句
	 * @param params
	 *            hql语句中的参数，如果没有参数则传入一个null
	 * @param paramTypes
	 *            hql语句中参数对应的值，如果没有参数则传入一个nul
	 * @return 返回单条数据
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object queryCountByHql(final String hql, final List<Object> params,
			final List<Type> paramTypes) {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (params != null && !params.isEmpty()) {
					query.setParameters(params.toArray(),
							paramTypes.toArray(new Type[paramTypes.size()]));
				}
				return query.uniqueResult();
			}
		});
	}

	/**
	 * 根据DetachedCriteria来查询数据
	 * 
	 * @param criteria
	 *            查询规则
	 * @param isPage
	 *            是否要分页，true表示分页，其他不分页
	 * @param pageNo
	 *            第几页
	 * @param pageSize
	 *            一页显示的数据
	 * @return 集合中的第一个元素是一页数据，第二个元素是总行数
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> queryByCriteria(final DetachedCriteria criteria,
			final boolean isPage, final int pageNo, final int pageSize) {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						List list = new ArrayList();
						if (isPage) {
							Criteria dc = criteria
									.getExecutableCriteria(session);
							// 查询一页的数据
							List data = dc
									.setFirstResult((pageNo - 1) * pageSize)
									.setMaxResults(pageSize).list();
							list.add(0, data);

							// 查询总行数
							dc.setProjection(Projections.rowCount());
							dc.setFirstResult(0);
							dc.setMaxResults(1);
							Object obj = dc.uniqueResult();
							int rowcount = Integer.parseInt(obj + "");
							list.add(1, rowcount);
						} else {
							List data = criteria.getExecutableCriteria(session)
									.list();
							return data;
						}
						return list;
					}
				});
	}

	/**
	 * 保存对象
	 * 
	 * @param transientInstance
	 *            要保存的对象
	 */
	public void save(T t) {
		try {
			//getHibernateTemplate().getSessionFactory().openSession().setFlushMode(FlushMode.COMMIT);
			getHibernateTemplate().save(t);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * 删除对象
	 * 
	 * @param persistentInstance
	 */
	public void delete(T persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * 根据id来查询对象
	 * 
	 * @param id
	 *            对象的id
	 * @return 查询返回的对象
	 */
	@SuppressWarnings("unchecked")
	public T findById(Serializable id) {
		try {
			T instance = (T) getHibernateTemplate().get(clazz, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * 根据对象来查询，对象中有查询的条件
	 * 
	 * @param instance
	 *            对象
	 * @return 返回集合
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T instance) {
		try {
			List<T> results = getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * 保存或者更新
	 * 
	 * @param instance
	 *            要保存或者更新的对象
	 */
	public void saveOrUpdate(T instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
