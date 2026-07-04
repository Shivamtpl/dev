//package roomRental;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/")
//@CrossOrigin(origins = "*") // Allow frontend access
//public class ListingController {
//
//    private final ListingRepository listingRepo;
//
//    public ListingController(ListingRepository listingRepo) {
//        this.listingRepo = listingRepo;
//    }
//
//    @GetMapping
//    public List<Listing> getAll() {
//        return listingRepo.findAll();
//    }
//
//    @GetMapping("/filter")
//    public List<Listing> filter(
//            @RequestParam String city,
//            @RequestParam String type,
//            @RequestParam int min,
//            @RequestParam int max) {
//        return listingRepo.findByCityAndTypeAndPriceBetween(city, type, min, max);
//    }
//
//    @PostMapping
//    public Listing addListing(@RequestBody Listing listing) {
//        return listingRepo.save(listing);
//    }
//}
//
