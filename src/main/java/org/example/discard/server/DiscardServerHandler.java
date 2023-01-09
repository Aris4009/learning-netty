package org.example.discard.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		ByteBuf byteBuf = (ByteBuf) msg;
		try {
			while (byteBuf.isReadable()) {
				char c = (char) byteBuf.readByte();
				if (Character.isWhitespace(c)) {
					continue;
				}
				log.info("{}", c);
			}
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		log.error(cause.getMessage(), cause);
		ctx.close();
	}
}
