package com.paipai.server.service.rest.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.paipai.server.domain.Customer;
import com.paipai.server.domain.Reservation;
import com.paipai.server.domain.ReservationStatus;
import com.paipai.server.domain.Restaurant;
import com.paipai.server.domain.basic.Gender;
import com.paipai.server.domain.basic.Location;
import com.paipai.server.domain.table.Table;
import com.paipai.server.domain.table.TableCategory;
import com.paipai.server.domain.table.TableCategoryStrategy;


@Path("/queue")
public class QueueServiceMock {

	/**
	 * ����ˢ��ά�룬���뿪ʼ�Ŷ�
	 * @param id �û�ID
	 * @param count ����Ͳ�����
	 * @param code �͹ݶ�ά��
	 * @return ���ؿձ�ʾ����ʧ�ܣ���Ҫ���ԣ����򷵻ض��������Ԥ��ʱ��ȵ�
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/reservation/{user}/{diner_count}/{bar_code}")
	public ReservationStatus requestReservation(@PathParam("user") long id, 
			@PathParam("diner_count") int count, 
			@PathParam("bar_code") String code) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setBirthday(new Date());
		customer.setEmail("zh_bjut@163.com");
		customer.setGender(Gender.Male);
		customer.setMobilePhoneNumber("18600017039");
		customer.setNickname("Huan");
		customer.setPassword("password");
		
		Restaurant restaurant = new Restaurant();
		restaurant.setId(123);
		restaurant.setName("ȫ�۵£��廪�Ƽ�԰�꣩");
		restaurant.setContactPerson("������");
		restaurant.setBarCode(code);
		
		Location location = new Location(1L, "����", "����", "������", "�ɸ�·�廪�Ƽ�԰");
		location.setLatitude(-109.09f);
		location.setLongitude(191.09f);
		
		restaurant.setLocation(location);
		restaurant.setMobileNumber("15877619875");
		restaurant.setTelPhoneNumber("010-231231");
		restaurant.setType(null);
		
		List<Table> tables = new ArrayList<Table>();
		tables.add(new Table(TableCategory.Peer, 10));
		tables.add(new Table(TableCategory.Small, 20));
		tables.add(new Table(TableCategory.Medium, 12));
		tables.add(new Table(TableCategory.Large, 4));
		restaurant.setTables(tables);
		
		TableCategoryStrategy strategy = new TableCategoryStrategy(2, 4, 6, 10);
		restaurant.setTableStrategy(strategy);
		
		Reservation reservation = new Reservation(
				customer, restaurant, count);
		ReservationStatus rs = new ReservationStatus(reservation);
		return rs;
	}
	
	/**
	 * ����ָ���Ŷ�������ϸ��Ϣ
	 * @param id ����ID
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/reservation/{id}")
	public Reservation getReservation(@PathParam("id") long id) {
		Customer customer = new Customer();
		customer.setId(10000);
		customer.setBirthday(new Date());
		customer.setEmail("zh_bjut@163.com");
		customer.setGender(Gender.Male);
		customer.setMobilePhoneNumber("18600017039");
		customer.setNickname("Huan");
		customer.setPassword("password");
		
		Restaurant restaurant = new Restaurant();
		restaurant.setId(123);
		restaurant.setName("ȫ�۵£��廪�Ƽ�԰�꣩");
		restaurant.setContactPerson("������");
		restaurant.setBarCode("barcode");
		
		Location location = new Location(1L, "����", "����", "������", "�ɸ�·�廪�Ƽ�԰");
		location.setLatitude(-109.09f);
		location.setLongitude(191.09f);
		
		restaurant.setLocation(location);
		restaurant.setMobileNumber("15877619875");
		restaurant.setTelPhoneNumber("010-231231");
		restaurant.setType(null);
		
		List<Table> tables = new ArrayList<Table>();
		tables.add(new Table(TableCategory.Peer, 10));
		tables.add(new Table(TableCategory.Small, 20));
		tables.add(new Table(TableCategory.Medium, 12));
		tables.add(new Table(TableCategory.Large, 4));
		restaurant.setTables(tables);
		
		TableCategoryStrategy strategy = new TableCategoryStrategy(2, 4, 6, 10);
		restaurant.setTableStrategy(strategy);
		
		Reservation reservation = new Reservation(
				customer, restaurant, 8);
		reservation.setId(id);
		
		return reservation;
	}
	
	/**
	 * ����ָ���͹ݵ������Ŷ����루��˳��
	 * @param restaurantId �͹�ID
	 * @return ��������
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/reservation/restaurant/{id}")
	public List<Reservation> getReservationsByRestaurantId(@PathParam("id") long restaurantId) {
		List<Reservation> reservationList = new ArrayList<Reservation>();
		
		Customer customer = new Customer();
		customer.setId(10000);
		customer.setBirthday(new Date());
		customer.setEmail("zh_bjut@163.com");
		customer.setGender(Gender.Male);
		customer.setMobilePhoneNumber("18600017039");
		customer.setNickname("Huan");
		customer.setPassword("password");
		
		Restaurant restaurant = new Restaurant();
		restaurant.setId(restaurantId);
		restaurant.setName("ȫ�۵£��廪�Ƽ�԰�꣩");
		restaurant.setContactPerson("������");
		restaurant.setBarCode("barcode");
		
		Location location = new Location(1L, "����", "����", "������", "�ɸ�·�廪�Ƽ�԰");
		location.setLatitude(-109.09f);
		location.setLongitude(191.09f);
		
		restaurant.setLocation(location);
		restaurant.setMobileNumber("15877619875");
		restaurant.setTelPhoneNumber("010-231231");
		restaurant.setType(null);
		
		List<Table> tables = new ArrayList<Table>();
		tables.add(new Table(TableCategory.Peer, 10));
		tables.add(new Table(TableCategory.Small, 20));
		tables.add(new Table(TableCategory.Medium, 12));
		tables.add(new Table(TableCategory.Large, 4));
		restaurant.setTables(tables);
		
		TableCategoryStrategy strategy = new TableCategoryStrategy(2, 4, 6, 10);
		restaurant.setTableStrategy(strategy);
		
		Reservation reservation = new Reservation(
				customer, restaurant, 8);
		reservation.setId(1);

		reservationList.add(reservation);
		return reservationList;
	}
	
	/**
	 * ����ָ���Ŷ������״̬����Ԥ��ʱ��ȵ�
	 * @param reservationId ����ID
	 * @return �Ŷ������״̬��Ϣ
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/reservation/{id}/status")
	public ReservationStatus getReservationStatus(@PathParam("id") long reservationId) {
		Customer customer = new Customer();
		customer.setId(1091);
		customer.setBirthday(new Date());
		customer.setEmail("zh_bjut@163.com");
		customer.setGender(Gender.Male);
		customer.setMobilePhoneNumber("18600017039");
		customer.setNickname("Huan");
		customer.setPassword("password");
		
		Restaurant restaurant = new Restaurant();
		restaurant.setId(123);
		restaurant.setName("ȫ�۵£��廪�Ƽ�԰�꣩");
		restaurant.setContactPerson("������");
		restaurant.setBarCode("barcode");
		
		Location location = new Location(1L, "����", "����", "������", "�ɸ�·�廪�Ƽ�԰");
		location.setLatitude(-109.09f);
		location.setLongitude(191.09f);
		
		restaurant.setLocation(location);
		restaurant.setMobileNumber("15877619875");
		restaurant.setTelPhoneNumber("010-231231");
		restaurant.setType(null);
		
		List<Table> tables = new ArrayList<Table>();
		tables.add(new Table(TableCategory.Peer, 10));
		tables.add(new Table(TableCategory.Small, 20));
		tables.add(new Table(TableCategory.Medium, 12));
		tables.add(new Table(TableCategory.Large, 4));
		restaurant.setTables(tables);
		
		TableCategoryStrategy strategy = new TableCategoryStrategy(2, 4, 6, 10);
		restaurant.setTableStrategy(strategy);
		
		Reservation reservation = new Reservation(
				customer, restaurant, 5);
		reservation.setId(reservationId);
		ReservationStatus rs = new ReservationStatus(reservation);
		return rs;
	}
	
	/**
	 * �޸ľͲ�����
	 * @param reservationId
	 * @param count
	 * @return
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/reservation/{id}/diners/{dinerCount}")
	public ReservationStatus changeDinerCount(@PathParam("id") long reservationId, 
			@PathParam("dinerCount") int count) {
		Customer customer = new Customer();
		customer.setId(1091);
		customer.setBirthday(new Date());
		customer.setEmail("zh_bjut@163.com");
		customer.setGender(Gender.Male);
		customer.setMobilePhoneNumber("18600017039");
		customer.setNickname("Huan");
		customer.setPassword("password");
		
		Restaurant restaurant = new Restaurant();
		restaurant.setId(123);
		restaurant.setName("ȫ�۵£��廪�Ƽ�԰�꣩");
		restaurant.setContactPerson("������");
		restaurant.setBarCode("barcode");
		
		Location location = new Location(1L, "����", "����", "������", "�ɸ�·�廪�Ƽ�԰");
		location.setLatitude(-109.09f);
		location.setLongitude(191.09f);
		
		restaurant.setLocation(location);
		restaurant.setMobileNumber("15877619875");
		restaurant.setTelPhoneNumber("010-231231");
		restaurant.setType(null);
		
		List<Table> tables = new ArrayList<Table>();
		tables.add(new Table(TableCategory.Peer, 10));
		tables.add(new Table(TableCategory.Small, 20));
		tables.add(new Table(TableCategory.Medium, 12));
		tables.add(new Table(TableCategory.Large, 4));
		restaurant.setTables(tables);
		
		TableCategoryStrategy strategy = new TableCategoryStrategy(2, 4, 6, 10);
		restaurant.setTableStrategy(strategy);
		
		Reservation reservation = new Reservation(
				customer, restaurant, count);
		reservation.setId(reservationId);
		ReservationStatus rs = new ReservationStatus(reservation);
		return rs;
	}
}