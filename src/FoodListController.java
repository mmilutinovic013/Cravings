
public class FoodListController 
{
    private FoodListController theFoodListCntl;
    private FoodListView theFoodListView;
    private MainMenuController parentMainMenuController;

    public FoodListController(MainMenuController theMainMenuController)
    {
    parentMainMenuController = theMainMenuController;
    showFoodListUI();
    }

    public void showFoodListUI()
    {
        theFoodListView = new FoodListView(this);
        theFoodListView.setVisible(true);
    }
    
    public FoodListController getFoodListCntl()
    {
        return theFoodListCntl;
    }
    
    public void hideFoodListUI()
    {
        theFoodListView.setVisible(false);
    }

    public void showMainMenu()
    {
    System.out.println(parentMainMenuController);
        parentMainMenuController.showMenu();// Need to understand what this is.
    }
    
}