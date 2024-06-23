class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set = new HashSet<>();
        for(String supplie: supplies) {
            set.add(supplie);
        }
        List<String> result = new ArrayList<>();
        boolean found = true;
        while(found) {
            found = false;
            for(int i=0; i<recipes.length; i++) {
                if(set.contains(recipes[i])) {//check set in recipes
                    continue;
                }
                List<String>ingredient =  ingredients.get(i);
                boolean flag = true;
                for(String ingred :ingredient) {
                    if(!set.contains(ingred)) {//check set in ingredident
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    found = true;
                    result.add(recipes[i]);
                    set.add(recipes[i]);
                    
                }
            }
            
        }
        return result; 
    }
}
//check karnar suplies ahet ka recipes madhye
//mg ingrendent ghe mg check set mahdye item ahet ka, nahi ahet atr add noko karus