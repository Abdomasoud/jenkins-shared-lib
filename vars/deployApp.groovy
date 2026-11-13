def call(Map cfg) {
    def u = new org.masoud.Utils(this)
    if (cfg.env == 'prod') {
        input message: "Deploy ${cfg.tag} to prod?"
    }
    def manifest = libraryResource 'k8s/deployment.yaml'
    writeFile file: 'deployment.yaml',
              text: manifest.replace('__IMAGE__', cfg.tag).replace('__ENV__', cfg.env)
    u.log("deploying ${cfg.tag} to ${cfg.env}")
    sh 'cat deployment.yaml'   // real version: kubectl apply -f deployment.yaml
}