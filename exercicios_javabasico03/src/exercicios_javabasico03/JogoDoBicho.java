package exercicios_javabasico03;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JogoDoBicho {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("O jogo do bicho é proibido por lei");
		System.out.print("Tem certeza de que quer jogar? ");
		String decisao = input.nextLine();
		if(decisao.equals("sim")) {
			System.out.println("É por sua conta e risco!");
			String[] JogoDoBicho = {"Avestruz", "Águia","Burro","Borboleta","Cachorro","Cabra", "Carneiro","Camelo", "Cobra", "Coelho","Cavalo", "Elefante", "Galo", "Gato","Jacaré", "Leão", "Macaco","Porco", "Pavão","Peru","Touro","Tigre","Urso","Veado","Vaca"};
			int[] bilhete = ordenaBilhete(rand, JogoDoBicho);
			int[] bilhete2 = removeDuplicado(bilhete);
			for(int l = 0; l < bilhete2.length; l++) {
				System.out.print(JogoDoBicho[bilhete2[l]] + " ");
			}
			
		}else if(decisao.equals("não") || decisao.equals("nao")) {
			System.out.println("Muito bem");
		}
		input.close();
	 }
	 public static int[] ordenaBilhete(Random rand, String[] JogoDoBicho) {
		 int[] bilhete = new int[5];
		 for(int i = 0; i < 5; i++) {
			 int rand_int = rand.nextInt(25);
			 bilhete[i] = rand_int;
			 }
		 Arrays.sort(bilhete);
		 return bilhete;
	 }
	 public static int[] removeDuplicado(int[] bilhete) {
		 int numeroDeDuplicados = 0;
		 int len = bilhete.length;
		 for(int i = 0; i < len - 1; i++) {
			 if(bilhete[i] == bilhete[i+1]) {
				 numeroDeDuplicados += 1;
			 }
		 }
		 if(numeroDeDuplicados == 0) {
			 return bilhete;
		 }
		 int[] arrayAuxiliar = new int[5-numeroDeDuplicados];
		 int h = 0;
		 for(int j = 0; j < len-1; j++) {
			 if(bilhete[j] != bilhete[j+1]) {
				 arrayAuxiliar[h] = bilhete[j];
				 h += 1;
			 }
			 arrayAuxiliar[4-numeroDeDuplicados] = bilhete[4]; 
		 }
		 return arrayAuxiliar;
	 }

}
