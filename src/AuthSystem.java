import java.io.*;
import java.nio.file.Path;
// ЭТО КЛАСС ДЛЯ МОЕГО ОБУЧЕНИЯ, ТУТ НЕЧЕГО СМОТРЕТЬ // удалить потом, взять отсюда работу с файлами
class AuthSystem {
    public static void main(String[] args)  {

//        try {
////            char[] array = new char[1024];
////            Reader input = new FileReader("Users.txt");
////            System.out.println(input.ready());
////            input.read(array);
////            System.out.println(array);
////            input.close();
////            FileInputStream file = new FileInputStream("Users.txt");
////            InputStreamReader inputStreamReader = new InputStreamReader(file);
////            StringBuilder stringBuilder = new StringBuilder();
////            int t;
////            while ((t = inputStreamReader.read()) != -1) {
////                char currentChar = (char) t;
////                System.out.println("symbol " + currentChar);
////
////                stringBuilder.append(currentChar);
////                System.out.println("inputStreamReader.ready() "+inputStreamReader.ready());
////            }
////            System.out.println(stringBuilder);
////            FileReader fileReader = new FileReader("Users.txt");
////            BufferedReader bufferedReader = new BufferedReader(fileReader);
//////            int t;
//////            while ((t = bufferedReader.read()) != -1) {
//////                System.out.println((char)t);
//////            }
////            String s;
////            while ((s = bufferedReader.readLine() )!= null){
////                System.out.println(s);
////            }
////            InputStream stream = System.in;
////            InputStreamReader isr = new InputStreamReader(stream);
////            BufferedReader br = new BufferedReader(isr);
////            String line =  br.readLine();
////            System.out.println(line);
////            OutputStream out = new FileOutputStream("Users.txt");
////            String greetings = "Привет мой дорогой друг";
////            out.write(greetings.getBytes());
////            out.close();
////            ByteArrayOutputStream bos = new ByteArrayOutputStream();
////            String text = "hello world";
////            byte[] bytes = text.getBytes();
////
////            bos.write(bytes);
////            System.out.println(bos.toString());
////            byte[] array =  bos.toByteArray();
////            for (int i = 0; i < array.length; i++) {
////                System.out.println((char)array[i]);
////
////            }
////            Writer writer = new FileWriter("Users.txt");
////            String content = "New infooo";
////            writer.write(content);
////            writer.close();
//
//
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
//        try (FileWriter fileWriter = new FileWriter("Users.txt");
//             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//             InputStream inputStream = System.in;
//             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)){
//            String text;
//            while(!"ESC".equals(text = bufferedReader.readLine())){
//                bufferedWriter.write(text + "\n");
//                bufferedWriter.flush();
//            }
//        } catch (IOException e){
//            System.out.println(e);
//        }
        Path path = Path.of("Users.txt");
        System.out.println("path.getFileName() = " + path.getFileName());
        System.out.println("path.getParent() = " + path.getParent());

    }
}