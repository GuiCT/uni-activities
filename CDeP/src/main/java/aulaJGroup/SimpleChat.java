// Tutorial em jgroups.org
package aulaJGroup;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

import java.io.*;
import java.util.List;
import java.util.LinkedList;

public class SimpleChat extends ReceiverAdapter {
    JChannel channel;
    String user_name=System.getProperty("user.name", "n/a");
    final List<String> state=new LinkedList<String>();

    public void viewAccepted(View new_view) {
        System.out.println("Entering 'viewAccepted'");
        System.out.println("** view: " + new_view);
    }

    public void receive(Message msg) {
        System.out.println("Entering 'receive'");
        String line=msg.getSrc() + ": " + msg.getObject();
        System.out.println(line);
        synchronized(state) {
            state.add(line);
        }
    }

    public void getState(OutputStream output) throws Exception {
        System.out.println("Entering 'getState'");
        synchronized(state) {
            System.out.println("Entering synchronized state in 'getState'");
            Util.objectToStream(state, new DataOutputStream(output));
        }
    }

    public void setState(InputStream input) throws Exception {
        System.out.println("Entering 'setState'");
        List<String> list=(List<String>)Util.objectFromStream(new DataInputStream(input));
        synchronized(state) {
            System.out.println("Entering synchronized state in 'setState'");
            state.clear();
            state.addAll(list);
        }
        System.out.println("received state (" + list.size() + " messages in chat history):");
        for(String str: list) {
            System.out.println(str);
        }
    }


    private void start() throws Exception {
        System.out.println("Entering 'start'");
        channel=new JChannel();
        channel.setReceiver(this);
        channel.connect("ChatCluster");
        channel.getState(null, 10000);
        eventLoop();
        channel.close();
    }

    private void eventLoop() {
        System.out.println("Entering 'eventLoop'");
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                System.out.print("> "); System.out.flush();
                String line=in.readLine().toLowerCase();
                if(line.startsWith("quit") || line.startsWith("exit")) {
                    break;
                }
                line="[" + user_name + "] " + line;
                Message msg=new Message(null, line);
                channel.send(msg);
            }
            catch(Exception e) {
            }
        }
    }


    public static void main(String[] args) throws Exception {
        new SimpleChat().start();
    }
}
