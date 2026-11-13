def call(Map cfg = [:]) {
    if (!cfg.image) { error 'dockerBuildPush: image is required' }
    def tag = "${cfg.image}:${cfg.tag ?: env.BUILD_NUMBER}"
    def run = cfg.dryRun == false ? '' : 'echo '   // lab container has no Docker
    sh "${run}docker build -t ${tag} ${cfg.context ?: '.'}"
    sh "${run}docker push ${tag}"
    return tag
}