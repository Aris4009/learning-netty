package org.example.time.client;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeClientHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		ByteBuf byteBuf = (ByteBuf) msg;
		try {
			long time = byteBuf.readInt();
			Instant instant = Instant.ofEpochSecond(time);
			LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("+08:00:00"));
			log.info(localDateTime.toString());
			ctx.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			byteBuf.release();
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		log.error(cause.getMessage(), cause);
		ctx.close();
	}
}
