package com.paipai.server.service.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.paipai.server.domain.Reservation;
import com.paipai.server.domain.ReservationStatus;

@Path("/queue")
public class QueueService {

	/**
	 * ����ˢ��ά�룬���뿪ʼ�Ŷ�
	 * @param id �û�ID
	 * @param count ����Ͳ�����
	 * @param code �͹ݶ�ά��
	 * @return ���ؿձ�ʾ����ʧ�ܣ���Ҫ���ԣ����򷵻ض��������Ԥ��ʱ��ȵ�
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/reservation/{user}/{diner_count}/{bar_code}")
	public ReservationStatus requestReservation(@PathParam("user") long id, 
			@PathParam("diner_count") int count, 
			@PathParam("bar_code") String code) {
		return null;
	}
	
	/**
	 * ����ָ���Ŷ�������ϸ��Ϣ
	 * @param id ����ID
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/reservation/{id}")
	public Reservation getReservation(@PathParam("id") long id) {
		return null;
	}
	
	/**
	 * ����ָ���͹ݵ������Ŷ����루��˳��
	 * @param restaurantId �͹�ID
	 * @return ��������
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/reservation/restaurant/{id}")
	public List<Reservation> getReservationsByRestaurantId(@PathParam("id") long restaurantId) {
		return null;
	}
	
	/**
	 * ����ָ���Ŷ������״̬����Ԥ��ʱ��ȵ�
	 * @param reservationId ����ID
	 * @return �Ŷ������״̬��Ϣ
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/reservation/{id}/status")
	public ReservationStatus getReservationStatus(@PathParam("id") long reservationId) {
		return null;
	}
	
	/**
	 * �޸ľͲ�����
	 * @param reservationId
	 * @param count
	 * @return
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/reservation/{id}/diners/{dinerCount}")
	public ReservationStatus changeDinerCount(@PathParam("id") long reservationId, 
			@PathParam("dinerCount") int count) {
		return null;
	}
}
