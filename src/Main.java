// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import org.jgap.Chromosome;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
public class Main {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        int monto=925;

        //estructura genetica
        DefaultConfiguration VConfig = new DefaultConfiguration();
        VConfig.setPreservFittestIndividual(true);


        FAptitud vfuncaptitud = new FAptitud(monto);
        VConfig.setFitnessFunction(vfuncaptitud);

        Gene[] vgene = new Gene[6];
        vgene[0]  =new IntegerGene(VConfig,0,10);
        vgene[1]  =new IntegerGene(VConfig,0,10);
        vgene[2]  =new IntegerGene(VConfig,0,10);
        vgene[3]  =new IntegerGene(VConfig,0,10);
        vgene[4]  =new IntegerGene(VConfig,0,10);
        vgene[5]  =new IntegerGene(VConfig,0,10);


        //definir el cromosoma
        IChromosome vcromosoma = new Chromosome(VConfig,vgene);
        VConfig.setSampleChromosome(vcromosoma);
        //

        //definir el numero de la polbacion de individuos inicial
        VConfig.setPopulationSize(200);
        //llenado aleatorio de valores para cada los 5000 indivuos
        Genotype poblacion = Genotype.randomInitialGenotype(VConfig);

        for(int generacion=1;generacion<=1000;generacion++)
            poblacion.evolve();

        //extrae el indiviuo mas apto
        IChromosome Indmasapto = poblacion.getFittestChromosome();

        System.out.println("El individuo mas apto encontrado tiene una aptitud de:"+Indmasapto.getFitnessValue());
        System.out.println("y esta formado por las siguientes monedas:");
        System.out.println(FAptitud.getNumdeMonedas(Indmasapto,0) + " moneda de 1 dolar");
        System.out.println(FAptitud.getNumdeMonedas(Indmasapto,1) + " moneda de 0,5 dolar");
        System.out.println(FAptitud.getNumdeMonedas(Indmasapto,2) + " moneda de 0,25 dolar");
        System.out.println(FAptitud.getNumdeMonedas(Indmasapto,3) + " moneda de 0,10 dolar");
        System.out.println(FAptitud.getNumdeMonedas(Indmasapto,4) + " moneda de 0,05 dolar");
        System.out.println(FAptitud.getNumdeMonedas(Indmasapto,5) + " moneda de 0,01 dolar");

        System.out.println("para un total de "+FAptitud.getTotalMonto(Indmasapto)+ " en centavos en  "
                + FAptitud.getTotalMonedas(Indmasapto)+ " monedas");



    }
}