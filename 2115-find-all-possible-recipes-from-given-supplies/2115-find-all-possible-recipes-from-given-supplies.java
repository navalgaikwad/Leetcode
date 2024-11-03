class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String>set = new HashSet<>();
       
        for(String supplie: supplies){
            set.add(supplie);
        }
        List<String> result = new ArrayList<>();
        boolean found =true;
        while(found) {
            found =false;
            for(int i=0;i<recipes.length; i++){
                if(set.contains(recipes[i])) continue; // already presnet in the set
                
              List<String>ingredient = ingredients.get(i);
                boolean flag =true;
                for(String ingred: ingredient){
                    if(!set.contains(ingred)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                   found=true;
                   result.add(recipes[i]);
                   set.add(recipes[i]);
                }
            }
        }
        return result;   
    }
}
//run loop on receopeos use i 
