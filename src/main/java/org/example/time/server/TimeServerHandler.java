package org.example.time.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeServerHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		log.error(cause.getMessage(), cause);
		ctx.close();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		final ByteBuf time = ctx.alloc().buffer(4);
		int t = (int) (System.currentTimeMillis() / 1000L);
		log.info("{}", t);
		time.writeInt(t);

		final ChannelFuture channelFuture = ctx.writeAndFlush(time);
		channelFuture.addListener((ChannelFutureListener) future -> {
			assert channelFuture == future;
			ctx.close().addListener((ChannelFutureListener) future1 -> {
				log.info("链接关闭");
				System.exit(2);
			});
		});
//		channelFuture.addListener(ChannelFutureListener.CLOSE);
	}
}
