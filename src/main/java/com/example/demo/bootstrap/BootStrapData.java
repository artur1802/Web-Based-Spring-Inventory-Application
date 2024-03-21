package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

        if(partRepository.count()==0) {
            OutsourcedPart display = new OutsourcedPart();
            display.setCompanyName("Cellworld");
            display.setName("Display");
            display.setInv(10);
            display.setPrice(20.0);
            display.setId(111L);

            outsourcedPartRepository.save(display);

            OutsourcedPart battery = new OutsourcedPart();
            battery.setCompanyName("Cellworld");
            battery.setName("Battery");
            battery.setInv(10);
            battery.setPrice(25.0);
            battery.setId(112L);

            outsourcedPartRepository.save(battery);

            OutsourcedPart processor = new OutsourcedPart();
            processor.setCompanyName("Cellworld");
            processor.setName("Processor");
            processor.setInv(10);
            processor.setPrice(40.0);
            processor.setId(113L);

            outsourcedPartRepository.save(processor);

            InhousePart camera = new InhousePart();
            camera.setName("Camera");
            camera.setInv(10);
            camera.setPrice(55.0);
            camera.setId(114L);

            inhousePartRepository.save(camera);

            InhousePart motherBoard = new InhousePart();
            motherBoard.setName("MotherBoard");
            motherBoard.setInv(10);
            motherBoard.setPrice(20.0);
            motherBoard.setId(115L);

            inhousePartRepository.save(motherBoard);

        }

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }
        List<InhousePart> insourcedParts=(List<InhousePart>) inhousePartRepository.findAll();
        for(InhousePart part:insourcedParts){
            System.out.println(part.getName());
        }
        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        if(productRepository.count()==0) {
            Product smartphones = new Product("Smartphones",500,5);
            Product feature_phones = new Product("Feature Phones", 500.0, 5);
            Product foldable_phones = new Product("Foldable Phones", 500.0, 5);
            Product rugged_phones = new Product("Rugged Phones", 600.0, 5);
            Product budget_phones = new Product("Budget Phones", 600.0, 5);
            productRepository.save(smartphones);
            productRepository.save(feature_phones);
            productRepository.save(foldable_phones);
            productRepository.save(rugged_phones);
            productRepository.save(budget_phones);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
