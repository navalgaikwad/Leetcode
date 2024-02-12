class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set = new HashSet<>();
        
        for(String supplie: supplies) {
            set.add(supplie);
        }
        
        boolean found = true;
        List<String> result = new ArrayList<>();
        while(found) {
            found = false;
            for(int i=0; i<recipes.length; i++) {
             if(set.contains(recipes[i])) {
                 continue;
             }
             List<String>ingredient = ingredients.get(i);
             boolean flag = true;
             for(String ingred:ingredient) {
                 if(!set.contains(ingred)) {
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
//add suppies into set
//found flag
//check suplies in the receipes are present if present continue
//check for ingredient presmt in set if not break make flag false
//if everythning is okay add to the set and ans
