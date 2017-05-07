import java.io.*; 
import java.net.*; 

class TCPCliente { 

    public static void main(String argv[]) throws Exception 
    { 
        String sentence; 
        String echoSentence; 

        
        BufferedReader inFromUser =  new BufferedReader(new InputStreamReader(System.in)); 

        Socket clientSocket = new Socket("127.0.0.1", 9875); 
            
        PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream()); 
        
          
	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        
        
        
        System.out.println("Ingrese su nombre");
        sentence = inFromUser.readLine(); 
        outToServer.println(sentence); 

        System.out.println("Ingrese su contraseña");
        sentence = inFromUser.readLine();
        outToServer.println(sentence);
        
        echoSentence = inFromServer.readLine(); 

        System.out.println("DEL SERVIDOR: " + echoSentence); 

        clientSocket.close(); 
       
       
      
    } 
} 


        


