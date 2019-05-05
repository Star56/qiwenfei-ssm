package com.qiwenfei.note.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;


/**
 * 2019/3/27
 * sunshine
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {
    private byte[] req;
    private byte[] treq;
    private int counter;

    public MyClientHandler() {
        req = ("Unless required by applicable law or agreed to in writing, software\n"
                + "  distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                + "  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                + "  See the License for the specific language governing permissions and\n"
                + "  limitations under the License.This connector uses the BIO implementation that requires the JSSE\n"
                + "  style configuration. When using the APR/native implementation, the\n"
                + "  penSSL style configuration is required as described in the APR/native\n"
                + "  documentation.An Engine represents the entry point (within Catalina) that processes\n"
                + "  every request.  The Engine implementation for Tomcat stand alone\n"
                + "  analyzes the HTTP headers included with the request, and passes them\n"
                + "  on to the appropriate Host (virtual host)# Unless required by applicable law or agreed to in writing, software\n"
                + "# distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                + "# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                + "# See the License for the specific language governing permissions and\n"
                + "# limitations under the License.# For example, set the org.apache.catalina.util.LifecycleBase logger to log\n"
                + "# each component that extends LifecycleBase changing state:\n"
                + "#org.apache.catalina.util.LifecycleBase.level = FINE").getBytes();

        treq = "你好，我的名字是1234567!".getBytes(Charset.forName("utf-8"));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = (String) msg ;
        System.out.println("客户端： "+msg +" --->>counter: "+ (++counter));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       /*
       //拆包
       ByteBuf  msg = Unpooled.buffer(req.length);
        msg.writeBytes(req);
        ctx.writeAndFlush(msg);*/
       //粘包
        for (int i = 0; i <1000 ; i++) {
            ByteBuf  msg = Unpooled.buffer(treq.length);
            msg.writeBytes(treq);
            ctx.writeAndFlush(msg);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
